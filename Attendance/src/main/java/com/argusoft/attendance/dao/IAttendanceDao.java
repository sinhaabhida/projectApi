/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.attendance.dao;

import com.argusoft.attendance.model.Attendance;
import java.util.List;

/**
 *
 * @author mohil
 */
public interface IAttendanceDao {
    int addAttendance(Attendance attendance);
    int updateAttendance(Attendance attendance);
    List<Attendance> getAttendanceByEmployeeId(int employeeId);
    List<Attendance> getAttendanceByMonth(int employeeId,int month);
}
