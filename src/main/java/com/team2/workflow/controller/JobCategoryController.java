/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.controller;

import com.team2.workflow.model.JobCategory;
import com.team2.workflow.model.User;
import com.team2.workflow.service.CategoryService;
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
@RequestMapping("/category")
public class JobCategoryController {
    @Autowired
    CategoryService categoryService;
    
     @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody JobCategory jobCategory) {
        long id = categoryService.categoryCreation(jobCategory);
        return ResponseEntity.ok().body("New Category has been Created with ID:" + id);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
      categoryService.categoryDeletion(id);
      return ResponseEntity.ok().body("User has been deleted successfully.");
   }

    @GetMapping("/get")
    public ResponseEntity<List<JobCategory>> categories() {
        List<JobCategory> categories = categoryService.getCategoryList();
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody JobCategory jobCategory) {
        categoryService.categoryUpdation(id, jobCategory);
        return ResponseEntity.ok().body("User has been updated successfully.");
    }
    
}
