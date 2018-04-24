/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.service;

import com.team2.workflow.dao.JobCategoryDao;
import com.team2.workflow.model.JobCategory;
import com.team2.workflow.model.User;
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
public class CategoryService {
 
    @Autowired
    JobCategoryDao jobCategoryDaoImpl;
    
    @Transactional
    public long categoryCreation(JobCategory jobCategory) {
    return jobCategoryDaoImpl.addCategory(jobCategory);
    }
    
    @Transactional
    public void categoryUpdation(long catId,JobCategory jobCategory){
        jobCategoryDaoImpl.updateCategory(catId, jobCategory);
    }
    
    @Transactional
    public void categoryDeletion(long catId){
        jobCategoryDaoImpl.deleteCategory(catId);
    }
    
    @Transactional
    public List<JobCategory> getCategoryList(){
        return jobCategoryDaoImpl.getAllCategory();
    }
}
