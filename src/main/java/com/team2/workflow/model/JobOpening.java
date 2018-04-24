/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "job_openning")
public class JobOpening implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "job_name")
    String jobName;
    @Column(name = "job_min_exp")
    private int minExp;
    @Column(name = "jon_max_exp")
    private int maxExp;
    @Column(name = "job_opening_id")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date jobOpeningDate;
    @Column(name = "job_closing_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date jobClosingDate;
    @Column(name = "status")
    private boolean status;
    @ManyToOne
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private JobCategory jobcategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getMinExp() {
        return minExp;
    }

    public void setMinExp(int minExp) {
        this.minExp = minExp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }

    public Date getJobOpenningDate() {
        return jobOpeningDate;
    }

    public void setJobOpenningDate(Date jobOpenningDate) {
        this.jobOpeningDate = jobOpenningDate;
    }

    public Date getJobClosingDate() {
        return jobClosingDate;
    }

    public void setJobClosingDate(Date jobClosingDate) {
        this.jobClosingDate = jobClosingDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public JobCategory getJobCategory() {
        return jobcategory;
    }

    public void setJobCategory(JobCategory jobCategory) {
        this.jobcategory = jobCategory;
    }
    
}
