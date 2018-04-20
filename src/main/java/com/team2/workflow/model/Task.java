/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author abhishek
 */
@Entity
@Table(name = "task")
public class Task {

    public enum Status {
        InProgress, Resolved, Closed
    }

    public enum Priority {
        Low, Medium, High;
    }

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false)
    private long taskId;
    @Column(name = "task_name",nullable = false)
    private String taskName;
    @Column(name = "task_description" ,nullable = false)
    private String taskDescription;
    @Column(name = "task_priority",nullable = false)
    private Priority taskPriority;
    @Column(name="task_status",nullable = false)
    private Status taskStatus;
    @ManyToOne
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private User asignee;
    @ManyToOne
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private User creator;
    @Column(name = "completion_message" ,nullable = true)
    private String completionMessage;

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Priority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(Priority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Status taskStatus) {
        this.taskStatus = taskStatus;
    }

    public User getAsignee() {
        return asignee;
    }

    public void setAsignee(User asignee) {
        this.asignee = asignee;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getCompletionMessage() {
        return completionMessage;
    }

    public void setCompletionMessage(String completionMessage) {
        this.completionMessage = completionMessage;
    }

}
