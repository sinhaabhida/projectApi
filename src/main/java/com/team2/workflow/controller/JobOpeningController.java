/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.controller;

import com.team2.workflow.model.JobCategory;
import com.team2.workflow.model.JobOpening;
import com.team2.workflow.service.CategoryService;
import com.team2.workflow.service.JobOpeningService;
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


@Controller
@RequestMapping("/opening")
public class JobOpeningController {
     @Autowired
    JobOpeningService jobService;
    
     @PostMapping("/create")
    public ResponseEntity<?> createJob(@RequestBody JobOpening jobOpening) {
        long id = jobService.jobCreation(jobOpening);
        return ResponseEntity.ok().body("New Job Opening has been Created with ID:" + id);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
      jobService.jobDeletion(id);
      return ResponseEntity.ok().body("Job Opening has been Deleted successfully.");
   }

    @GetMapping("/get")
    public ResponseEntity<List<JobOpening>> openings() {
        List<JobOpening> openings = jobService.getJobList();
        return ResponseEntity.ok().body(openings);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody JobOpening jobOpening) {
        jobService.jobUpdation(id, jobOpening);
        return ResponseEntity.ok().body("Job Opening has been updated successfully.");
    }
}
