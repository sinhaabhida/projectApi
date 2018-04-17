/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.attendance.model;

import java.sql.Date;
import java.time.LocalDate;
import org.springframework.stereotype.Component;


/**
 *
 * @author mohil
 */
@Component
public class Attendance {

    private int id;
    private int employee_id;
    private Date date;

    public Attendance() {
        this.employee_id = -1;
        this.date =  Date.valueOf(LocalDate.now());
    }

    public Attendance(int employee_id, Date date) {
        this.employee_id = employee_id;
        this.date = date;
    }

    public Attendance(int id, int employee_id, Date date) {
        this.id = id;
        this.employee_id = employee_id;
        this.date = date;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
