/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.service;

import com.team2.workflow.dao.TaskDao;
import com.team2.workflow.model.Task;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abhishek
 */
@Service
@Transactional(readOnly = true)
public class TaskService {
     @Autowired
     TaskDao taskDaoImpl;

    @Transactional
    public long taskCreation(Task task) {
    return taskDaoImpl.addTask(task);
    }

    public Task getTaskByIdService(Long taskId) {
         Task task = taskDaoImpl.getTaskById(taskId);
         return task;
    }
    
    public List<Task> getTaskListService() {
         return taskDaoImpl.getAllTask();
    }

    public List<Task> getTaskListByUserIdService(long userId) {
         return taskDaoImpl.getListOfAssignedTaskFor(userId);
    }
    
    @Transactional
    public void updateTaskStatusService(long taskId ,Task.Status status){
        taskDaoImpl.changeTaskStatus(taskId, status);
    }
}
