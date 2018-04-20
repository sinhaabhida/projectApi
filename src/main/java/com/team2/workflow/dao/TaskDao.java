/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.dao;

import com.team2.workflow.model.Task;
import com.team2.workflow.model.Task.Status;
import com.team2.workflow.model.User;
import java.util.List;

/**
 *
 * @author abhishek
 */
public interface TaskDao {
    public long addTask(Task task);
    
    public void changeTaskStatus(long taskId,Status status);
    
    public List<Task> getAllTask();
    
    public Task getTaskById(long taskId);
    
    public List<Task> getListOfAssignedTaskFor(long userId);
}
