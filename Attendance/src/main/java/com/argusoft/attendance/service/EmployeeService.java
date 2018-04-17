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

/**
 *
 * @author mohil
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }
    
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }
    
    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }
    
    public List<Employee> getEmployeesByName(String employeeName) {
        return employeeDao.getEmployeesByName(employeeName);
    }
}
