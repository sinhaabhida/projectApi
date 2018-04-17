package com.team2.workflowmanagement.controller;

//import com.technovate.wms.Service.UserService;
//import org.activiti.engine.impl.util.json.JSONObject;
import com.team2.workflowmanagement.model.User;
import com.team2.workflowmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    UserService userService;
//    @Autowired
//    UserRepository repository;

    @PostMapping("/create_users")
    public boolean register(@RequestBody User data) {
        return userService.userRegistration(data);
    }

    @PostMapping("/delete_user")
    public boolean delete(@RequestBody Long id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/manage_users")
    public List<User> user() {
        System.out.println("/manage_users");
        return userService.getUsers();
    }

    @PostMapping("/getuser")
    public User getUser(@RequestBody Long id) {
        return userService.getUserService(id);
    }

    @PostMapping(value = "/update_user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateUser(@RequestBody User data) {
        return userService.updateUserService(data);
    }

    @GetMapping("/profile")
    public User profile(Principal principal) {
        return userService.getProfileService(principal.getName());
    }
}
