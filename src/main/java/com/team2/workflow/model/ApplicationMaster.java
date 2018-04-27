/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.print.attribute.standard.DateTimeAtCreation;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author abhishek
 */
@Entity
@Table(name = "aplication_master")
public class ApplicationMaster implements Serializable {

    @Id
    @GeneratedValue
    @Column(name ="id")
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name ="dob")
    private Date dob;
    @Column(name = "gender")
    private String gender;
    @Column(name = "mobile_no")
    private String mobile;
    @Column(name = "alternate_contact")
    private String alternateMobile;
    @Column(name = "employement_status")
    private String employmentStatus;
    @Column(name="current_position")
    private String currentPosition;
    @Column(name = "addr_line_1")
    private String addressLine1;
    @Column(name = "addr_line_2")
    private String addressLine2;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "resume")
    private String resume;
    @Column(name = "skills")
    private String skills;
    @Column(name = "exp")
    private int experience;
    @Column(name = "current_ctc")
    private double currentCtc;
    @Column(name = "expected_ctc")
    private double expectedCtc;
    @Column(name = "notice_period")
    private int noticePeriod;
    @Column(name = "reason_for_leaving")
    private String reasonForLeaving;
    @ManyToOne
    @Cascade(CascadeType.ALL)
    private JobOpening jobopening;
    @Column(name = "reference")
    private String reference;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "view_count")
    private int viewCount;

    public int getViewCount() {
        return viewCount;
    }

    public void incrementViewCount() {
        this.viewCount++;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(DateTimeAtCreation createdOn) {
        this.createdOn = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAlternateMobile() {
        return alternateMobile;
    }

    public void setAlternateMobile(String alternateMobile) {
        this.alternateMobile = alternateMobile;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public double getCurrentCtc() {
        return currentCtc;
    }

    public void setCurrentCtc(double currentCtc) {
        this.currentCtc = currentCtc;
    }

    public double getExpectedCtc() {
        return expectedCtc;
    }

    public void setExpectedCtc(double expectedCtc) {
        this.expectedCtc = expectedCtc;
    }

    public int getNoticePeriod() {
        return noticePeriod;
    }

    public void setNoticePeriod(int noticePeriod) {
        this.noticePeriod = noticePeriod;
    }

    public String getReasonForLeaving() {
        return reasonForLeaving;
    }

    public void setReasonForLeaving(String reasonForLeaving) {
        this.reasonForLeaving = reasonForLeaving;
    }

    public JobOpening getJobopening() {
        return jobopening;
    }

    public void setJobopening(JobOpening jobopening) {
        this.jobopening = jobopening;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
    
}

