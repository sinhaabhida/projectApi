package com.team2.workflow.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "role",nullable = false)
    String role;

    public Role() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
   
}
