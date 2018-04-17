/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.attendance.model;

import org.springframework.stereotype.Component;

/**
 *
 * @author mohil
 */
@Component
public class Employee {

    private int id;
    private String name;
    private int department_id;

    public Employee() {
        this.id = -1;
    }

    public Employee(int id, String name, int department_id) {
        this.id = id;
        this.name = name;
        this.department_id = department_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

}
