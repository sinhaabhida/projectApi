/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflowmanagement.dao;

import com.team2.workflowmanagement.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author abhishek
 */
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        String sql = "INSERT INTO user (active, deleted, email, last_name, first_name, password, role_id)"
                + " VALUES (?, ?, ?,?,?,?,?)";
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        String password = b.encode(user.getPassword());
        jdbcTemplate.update(sql, user.isActive(),user.isDeleted(),user.getEmail(),user.getLastName(),user.getFirstName(),password,user.getRole_id());
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE user set active=?, deleted=?, email=?, last_name=?, first_name=?, password=?, role_id=? where id=?";
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        String password = b.encode(user.getPassword());
        jdbcTemplate.update(sql, user.isActive(),user.isDeleted(),user.getEmail(),user.getLastName(),user.getFirstName(),password,user.getRole_id(),user.getId());        
    }

    @Override
    public void delete(long userId) {
       String sql = "DELETE from user where id=?";
       jdbcTemplate.update(sql,userId);
    }

    @Override
    public User get(long userId) {
       String sql = "SELECT * FROM user WHERE id= ?";
        User user = jdbcTemplate.queryForObject(
        sql,new Object[]{userId},new BeanPropertyRowMapper<User>(User.class));
        System.out.println(user.getFirstName()+" Called");
        return user;
    }

    @Override
    public List<User> listOfUsers() {
         String sql = "SELECT * FROM user";
        List<User> listOfUser = jdbcTemplate.query(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();

                  user.setId(rs.getLong("id"));
                  user.setActive(rs.getBoolean("active"));
                  user.setDeleted(rs.getBoolean("deleted"));
                  user.setEmail(rs.getString("email"));
                  user.setFirstName(rs.getString("first_name"));
                  user.setLastName(rs.getString("last_name"));
                  user.setRole_id(rs.getLong("role_id"));
                  
                  return user;
            }

        });

        return listOfUser;
    }

    @Override
    public User findByEmail(String email) {
        String sql = "SELECT * FROM user WHERE email= ?";
        User user = jdbcTemplate.queryForObject(
        sql,new Object[]{email},new BeanPropertyRowMapper<User>(User.class));
        System.out.println(user.getFirstName()+" Called");
        return user;
    }

}
