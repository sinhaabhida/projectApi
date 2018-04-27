/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.controller;

import com.team2.workflow.model.ApplicationMaster;
import com.team2.workflow.model.User;
import com.team2.workflow.service.ApplicationMasterService;
import com.team2.workflow.service.UserService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author abhishek
 */
@Controller
@RequestMapping("/application")
public class ApplicationMasterController {
     @Autowired
     ApplicationMasterService applicationService;
     
    @PostMapping("/create")
    public ResponseEntity<?> register(@RequestBody ApplicationMaster applicationData) {
        long id = applicationService.applicationSubmit(applicationData);
        return ResponseEntity.ok().body("New Application has been Submitted successfully:" + id);
    }

    @GetMapping("/get-latest")
    public ResponseEntity<List<ApplicationMaster>> user() {
        List<ApplicationMaster> applicationData = applicationService.fetchLatestApplicationData();
        return ResponseEntity.ok().body(applicationData);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApplicationMaster> getApplication(@PathVariable("id") long id) {
        ApplicationMaster applicationData = applicationService.getApplicationDetails(id);
        return ResponseEntity.ok().body(applicationData);
    }

    @GetMapping("/get-most-viewed")
    public ResponseEntity<List<ApplicationMaster>> getLatestApplication() {
        List<ApplicationMaster> applicationData = applicationService.fetchMostViewedApplicationData();
        return ResponseEntity.ok().body(applicationData);
    }
    
    @GetMapping("/get-by-opening/{id}")
    public ResponseEntity<List<ApplicationMaster>> getApplicationByOpening(@PathVariable("id") long id) {
        List<ApplicationMaster> applicationData = applicationService.getByJobOpening(id);
        return ResponseEntity.ok().body(applicationData);
    }

}
