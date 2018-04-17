/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.attendance.controller;

import com.argusoft.attendance.model.Employee;
import com.argusoft.attendance.service.EmployeeService;
import com.argusoft.attendance.service.EmployeeTxService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mohil
 */
@RestController
public class EmployeeDataController {

    @Autowired
    EmployeeService employeeService;
    
    @Autowired
    EmployeeTxService employeeTxService;
    
    @RequestMapping(value = {"/employeeTx"}, method = RequestMethod.GET)
    public List<Employee> getEmployeesTxData() {
        return employeeTxService.getEmployees();
    }

    @RequestMapping(value = {"/employee"}, method = RequestMethod.GET)
    public List<Employee> getEmployeesData() {
        return employeeService.getEmployees();
    }

    @RequestMapping(value = {"/employee/{id}"}, method = RequestMethod.GET)
    public Employee getEmployeeDataByPath(@PathVariable(name = "id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @RequestMapping(value = {"/employee"}, method = RequestMethod.POST)
    public ResponseEntity addEmployeeData(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = {"/employee"}, method = RequestMethod.PUT)
    public ResponseEntity updateEmployeeData(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = {"/employee"}, method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployeeData(@RequestBody Employee employee) {
        employeeService.deleteEmployee(employee.getId());
        return ResponseEntity.ok().build();
    }
}
