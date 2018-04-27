/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.dao;

import com.team2.workflow.model.ApplicationMaster;
import com.team2.workflow.model.JobCategory;
import java.util.List;

/**
 *
 * @author abhishek
 */
public interface ApplicationMasterDao {
    public long submitApplication(ApplicationMaster applicationData);
    
    public List<ApplicationMaster> fetchLatestApplication();
   
    public List<ApplicationMaster> fetchMostViewedApplications();
           
    public ApplicationMaster getApplicationDetails(long appId);
    
    public List<ApplicationMaster> getApplicationByJobOpenning(long openId);
}
