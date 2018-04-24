/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.dao;

import com.team2.workflow.model.JobCategory;
import com.team2.workflow.model.Task;
import java.util.List;

/**
 *
 * @author abhishek
 */
public interface JobCategoryDao {
    public long addCategory(JobCategory jobCategory);
    
    public void updateCategory(long catId,JobCategory jobCategory);
    
    public void deleteCategory(long catId);
    
    public List<JobCategory> getAllCategory();
}
