package com.team2.workflow.controller;

//import com.technovate.wms.Service.UserService;
//import org.activiti.engine.impl.util.json.JSONObject;
import com.team2.workflow.model.User;
import com.team2.workflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
//    @Autowired
//    UserRepository repository;

    @PostMapping("/create")
    public ResponseEntity<?> register(@RequestBody User user) {
        long id = userService.userRegistration(user);
        return ResponseEntity.ok().body("New User has been Created with ID:" + id);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
      userService.deleteUser(id);
      return ResponseEntity.ok().body("User has been deleted successfully.");
   }

    @GetMapping("/get")
    public ResponseEntity<List<User>> user() {
        System.out.println("/manage_users");
        List<User> users = userService.getUsers();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> get(@PathVariable("id") long id) {
        User user = userService.getUserService(id);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody User user) {
        userService.updateUserService(id, user);
        return ResponseEntity.ok().body("User has been updated successfully.");
    }

    @GetMapping("/profile")
    public ResponseEntity<User> profile(Principal principal) {
        User user = userService.getProfileService(principal.getName());
        return ResponseEntity.ok().body(user);
    }
}
