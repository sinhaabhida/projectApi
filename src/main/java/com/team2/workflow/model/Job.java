/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.model;

import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "job")
public class Job {

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
    @Column(name = "job_opennning_id")
    private Date jobOpenningDate;
    @Column(name = "job_closing_date")
    private Date jobClosingDate;
    @Column(name = "status")
    private boolean status;
    @ManyToOne
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private JobCategory jobCategory;
}
