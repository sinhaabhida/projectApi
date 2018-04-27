/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.service;

import com.team2.workflow.dao.ApplicationMasterDao;
import com.team2.workflow.dao.JobOpeningDao;
import com.team2.workflow.model.ApplicationMaster;
import com.team2.workflow.model.JobOpening;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abhishek
 */
@Service
public class ApplicationMasterService {

    @Autowired
    ApplicationMasterDao applicationMasterDaoImpl;

    @Transactional
    public long applicationSubmit(ApplicationMaster applicationData) {
        return applicationMasterDaoImpl.submitApplication(applicationData);
    }

    @Transactional
    public List<ApplicationMaster> fetchLatestApplicationData() {
        return applicationMasterDaoImpl.fetchLatestApplication();
    }

    @Transactional
    public List<ApplicationMaster> fetchMostViewedApplicationData() {
        return applicationMasterDaoImpl.fetchMostViewedApplications();
    }

    @Transactional
    public ApplicationMaster getApplicationDetails(long appId) {
        try {
            return applicationMasterDaoImpl.getApplicationDetails(appId);
        } catch (Exception e) {
        }
        return null;
    }

    @Transactional
    public List<ApplicationMaster> getByJobOpening(long openId) {
        try {
            return applicationMasterDaoImpl.getApplicationByJobOpenning(openId);
        } catch (Exception e) {
        }
        return null;
    }

}
