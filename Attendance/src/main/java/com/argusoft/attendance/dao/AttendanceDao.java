/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.attendance.dao;

import com.argusoft.attendance.model.Attendance;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mohil
 */
@Repository
public class AttendanceDao implements IAttendanceDao {

    private static JdbcTemplate jdbcTemplate;

    @Autowired
    private void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        AttendanceDao.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addAttendance(final Attendance attendance) {
        String insert = "insert into attendance (employee_id,a_date) values (?,?)";

        return jdbcTemplate.update(insert,
                attendance.getEmployee_id(),
                attendance.getDate());
    }

    @Override
    public int updateAttendance(final Attendance attendance) {
        String delete = "delete into attendance where id=?";

        return jdbcTemplate.update(delete, new PreparedStatementCallback<Integer>() {
            @Override
            public Integer doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                ps.setInt(0, attendance.getId());

                return ps.executeUpdate();
            }
        });
    }

    @Override
    public List<Attendance> getAttendanceByEmployeeId(int employeeId) {
        return jdbcTemplate.query("select * from attendance where employee_id="
                + employeeId, new RowMapper<Attendance>() {
            @Override
            public Attendance mapRow(ResultSet rs, int i) throws SQLException {
                 return new Attendance(
                         rs.getInt("id"),
                         rs.getInt("employee_id"),
                         rs.getDate("a_date")
                 );
            }
        });
    }

    @Override
    public List<Attendance> getAttendanceByMonth(int employeeId, int month) {
        return jdbcTemplate.query("select * from attendance where employee_id="
                + employeeId + " and MONTH(a_date)=" + month,
                new RowMapper<Attendance>() {
            @Override
            public Attendance mapRow(ResultSet rs, int i) throws SQLException {
                 return new Attendance(
                         rs.getInt("id"),
                         rs.getInt("employee_id"),
                         rs.getDate("a_date")
                 );
            }
        });
    }

}
