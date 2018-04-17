/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.attendance.service;

import com.argusoft.attendance.dao.AttendanceDao;
import com.argusoft.attendance.model.Attendance;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mohil
 */
@Service
public class AttendanceService {

    @Autowired
    private AttendanceDao attendanceDao;

    public void addAttendance(Attendance attendance) {
        attendanceDao.addAttendance(attendance);
    }

    public void updateAttendance(Attendance attendance) {
        attendanceDao.updateAttendance(attendance);
    }
    
    public List<Attendance> getAttendanceByEmployeeId(int employeeId) {
        return attendanceDao.getAttendanceByEmployeeId(employeeId);
    }

    public List<Attendance> getAttendanceByMonth(int employeeId, int month) {
        return attendanceDao.getAttendanceByMonth(employeeId, month);
    }
}
