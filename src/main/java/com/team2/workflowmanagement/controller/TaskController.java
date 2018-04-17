//package com.team2.workflowmanagement.controller;
//
//import org.activiti.engine.HistoryService;
//import org.activiti.engine.TaskService;
//import org.activiti.engine.history.HistoricTaskInstance;
//import org.activiti.engine.task.Task;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//
//
//@RestController
//@RequestMapping("/tasks")
//public class TaskController {
//
//    @Autowired
//    TaskService taskService;
//    @Autowired
//    TaskServices taskServices;
//    @Autowired
//    HistoryService historyService;
//
//    @PostMapping(value = "/create_task",produces = MediaType.APPLICATION_JSON_VALUE)
//    public boolean createTask(@RequestBody TaskData taskData){
//        return taskServices.createTaskService(taskData);
//    }
//    @GetMapping("/list_task")
//    public List<TaskData> taskList(){
//        return taskServices.getTaskListService();
//    }
//    @PostMapping("/edit_task")
//    public TaskData edit_taskDetail(@RequestBody String taskId){
//        return taskServices.edit_taskDetailService(taskId);
//    }
//    @PostMapping(value = "/update_status",produces = MediaType.APPLICATION_JSON_VALUE)
//    public Map<String, Object> upadateStatus(@RequestBody UpdateData update){
//        System.out.println("update Data"+update.getStatus());
//        return taskServices.updateStatusService(update.getStatus(),update.getId());
//    }
//}
