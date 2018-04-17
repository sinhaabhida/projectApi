/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.attendance.dao;

import com.argusoft.attendance.model.Department;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mohil
 */
@Repository
public class DepartmentDao implements IDepartmentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addDepartment(Department department) {
        String insert = "insert into department (name) values (?)";

        return jdbcTemplate.update(insert, department.getName());
    }

    @Override
    public int updateDepartment(Department department) {
        String update = "update department set name=? where id=?";

        return jdbcTemplate.update(update, department.getName(), department.getId());
    }

    @Override
    public int deleteDepartment(int id) {
        String delete = "delete from department where id=?";

        return jdbcTemplate.update(delete, id);
    }

    @Override
    public List<Department> getDepartments() {
        return jdbcTemplate.query("select * from department",
                new RowMapper<Department>() {
            @Override
            public Department mapRow(ResultSet rs, int i) throws SQLException {
                return new Department(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }
        });
    }

    @Override
    public Department getDepartmentById(int id) {
        return jdbcTemplate.query("select * from department where id=" + id,
                new RowMapper<Department>() {
            @Override
            public Department mapRow(ResultSet rs, int i) throws SQLException {
                return new Department(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }
        }).get(0);
    }

}
