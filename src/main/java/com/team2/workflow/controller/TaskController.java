/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.controller;

import com.team2.workflow.model.Task;
import com.team2.workflow.model.UpdateTask;
import com.team2.workflow.service.TaskService;
import com.team2.workflow.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author abhishek
 */
@Controller
@RequestMapping("task")
public class TaskController {
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;
//    @Autowired
//    UserRepository repository;

    @PostMapping("/add")
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        long id = taskService.taskCreation(task);
        if(id!=0){
        return ResponseEntity.ok().body("New Task has been Created with ID:" + id);
        }
        else 
            return ResponseEntity.badRequest().body("Somethig went wrong");
    }

    @PostMapping("/update/status")
    public ResponseEntity<?> updateTaskStatus(@RequestBody UpdateTask data) {
        taskService.updateTaskStatusService(data.getId(), data.getStatus());
        return ResponseEntity.ok().body("Task has been "+data.getStatus()+" successfully.");
   }

    @GetMapping("/get_all")
    public ResponseEntity<List<Task>> allTasks() {
//        System.out.println("/manage_users");
        List<Task> tasks = taskService.getTaskListService();
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") long id) {
        Task task = taskService.getTaskByIdService(id);
        return ResponseEntity.ok().body(task);
    }

    @GetMapping("/get_task/{id}")
    public ResponseEntity<List<Task>> getTaskForUser(@PathVariable("id") long id) {
        List<Task> tasks = taskService.getTaskListByUserIdService(id);
        return ResponseEntity.ok().body(tasks);
    }

}
