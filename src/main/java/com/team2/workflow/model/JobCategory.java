/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "job_category")
public class JobCategory implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "category_name",nullable = false)
    private String categoryName;
    @Column(name = "category_description",nullable = false)
    private String categoryDescription;
    @Column(name = "status")
    private boolean status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
