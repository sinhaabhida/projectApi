/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.dao;

import com.team2.workflow.model.JobCategory;
import com.team2.workflow.model.JobOpening;
import java.util.List;

/**
 *
 * @author abhishek
 */
public interface JobOpeningDao {
     public long addOpening(JobOpening jobOpening);
    
    public void updateOpening(long openId,JobOpening jobOpening);
    
    public void deleteOpening(long openId);
    
    public List<JobOpening> getAllOpenings();
}
