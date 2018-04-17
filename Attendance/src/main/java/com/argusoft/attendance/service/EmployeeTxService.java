/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.attendance.service;

import com.argusoft.attendance.dao.EmployeeDao;
import com.argusoft.attendance.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mohil
 */
@Service
public class EmployeeTxService {
    
    @Autowired
    EmployeeDao employeeDao;
    
    @Transactional
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }
}
