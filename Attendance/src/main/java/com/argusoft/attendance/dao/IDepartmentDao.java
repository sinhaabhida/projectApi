/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.attendance.dao;

import com.argusoft.attendance.model.Department;
import java.util.List;

/**
 *
 * @author mohil
 */
public interface IDepartmentDao {
    int addDepartment(Department department);
    int updateDepartment(Department department);
    int deleteDepartment(int id);
    List<Department> getDepartments();
    Department getDepartmentById(int id);
}
