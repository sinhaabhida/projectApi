/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.service;

import com.team2.workflow.dao.JobCategoryDao;
import com.team2.workflow.dao.JobOpeningDao;
import com.team2.workflow.model.JobCategory;
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
public class JobOpeningService {

    @Autowired
    JobOpeningDao jobOpeningDaoImpl;

    @Transactional
    public long jobCreation(JobOpening jobOpening) {
        return jobOpeningDaoImpl.addOpening(jobOpening);
    }

    @Transactional
    public void jobUpdation(long openId, JobOpening jobOpening) {
        jobOpeningDaoImpl.updateOpening(openId, jobOpening);
    }

    @Transactional
    public void jobDeletion(long openId) {
        jobOpeningDaoImpl.deleteOpening(openId);
    }

    @Transactional
    public List<JobOpening> getJobList() {
        return jobOpeningDaoImpl.getAllOpenings();
    }
}
