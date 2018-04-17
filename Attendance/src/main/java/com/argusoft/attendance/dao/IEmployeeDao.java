/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.attendance.dao;

import com.argusoft.attendance.model.Employee;
import java.util.List;

/**
 *
 * @author mohil
 */
public interface IEmployeeDao {
    int addEmployee(Employee employee);
    int updateEmployee(Employee employee);
    int deleteEmployee(int id);
    List<Employee> getEmployees();
    List<Employee> getEmployeesByName(String employeeName);
    Employee getEmployeeById(int id);
}
