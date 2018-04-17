/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.attendance.service;

import com.argusoft.attendance.dao.DepartmentDao;
import com.argusoft.attendance.model.Department;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mohil
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public void addDepartment(Department department) {
        departmentDao.addDepartment(department);
    }

    public void updateDepartment(Department department) {
        departmentDao.updateDepartment(department);
    }

    public void deleteDepartment(int id) {
        departmentDao.deleteDepartment(id);
    }
    
    public Department getDepartmentById(int id) {
        return departmentDao.getDepartmentById(id);
    }
    
    public List<Department> getDepartments() {
        return departmentDao.getDepartments();
    }
}
