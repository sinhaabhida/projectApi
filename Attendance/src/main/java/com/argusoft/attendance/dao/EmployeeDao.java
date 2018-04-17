/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.attendance.dao;

import com.argusoft.attendance.model.Employee;
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
public class EmployeeDao implements IEmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addEmployee(final Employee employee) {
        String insert = "insert into employee (name,department_id) values (?,?)";

        return jdbcTemplate.update(insert, employee.getName(),
                employee.getDepartment_id());
    }

    @Override
    public int updateEmployee(Employee employee) {
        String update = "update employee set name=?,department_id=? where id=?";

        return jdbcTemplate.update(update, employee.getName(),
                employee.getDepartment_id(), employee.getId());
    }

    @Override
    public int deleteEmployee(int id) {
        String delete = "delete from employee where id=?";

        return jdbcTemplate.update(delete, id);
    }

    @Override
    public List<Employee> getEmployees() {
        return jdbcTemplate.query("select * from employee",
                new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int i) throws SQLException {
                return new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("department_id")
                );
            }
        });
    }

    @Override
    public Employee getEmployeeById(int id) {
        return jdbcTemplate.query("select * from employee where id=" + id,
                new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int i) throws SQLException {
                return new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("department_id")
                );
            }
        }).get(0);
    }

    @Override
    public List<Employee> getEmployeesByName(String employeeName) {
        return jdbcTemplate.query("select * from employee where name like '%"
                + employeeName + "%'",
                new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int i) throws SQLException {
                return new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("department_id")
                );
            }
        });
    }

}
