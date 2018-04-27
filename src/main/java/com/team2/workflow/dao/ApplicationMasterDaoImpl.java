/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.dao;

import com.team2.workflow.model.ApplicationMaster;
import com.team2.workflow.model.JobCategory;
import com.team2.workflow.model.JobOpening;
import com.team2.workflow.model.Role;
import com.team2.workflow.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abhishek
 */
@Repository
public class ApplicationMasterDaoImpl implements ApplicationMasterDao{

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public long submitApplication(ApplicationMaster applicationData) {
        JobOpening jobOpening;
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM JobOpening j WHERE j.id='" + applicationData.getJobopening().getId() + "' ";
        Query query = session.createQuery(hql);
        try {
            jobOpening = (JobOpening) query.list().get(0);
            if (jobOpening != null) {
                applicationData.setJobopening(jobOpening);
                session.save(jobOpening);
                return jobOpening.getId();
            }
        } catch (Exception E) {
            System.out.println("Index Exception Catched");
            System.out.print("no valid job opening id");
        }
        return 0;
    }

    @Override
    public List<ApplicationMaster> fetchLatestApplication() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM ApplicationMaster AM ORDER BY AM.createdOn";
        Query query = session.createQuery(hql);
        List<ApplicationMaster> applicationData = query.list();
        return applicationData;
    }
 
    @Override
    public List<ApplicationMaster> fetchMostViewedApplications() {
        String hql = "FROM ApplicationMaster am ORDER BY am.viewCount desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<ApplicationMaster> applicationData = query.list();
        return applicationData;
    }

    
    @Override
    public ApplicationMaster getApplicationDetails(long appId) {
        Session session = sessionFactory.getCurrentSession();
        ApplicationMaster applicationData = session.byId(ApplicationMaster.class).load(appId);
        applicationData.incrementViewCount();
        session.flush();
        return applicationData;
    }

    @Override
    public List<ApplicationMaster> getApplicationByJobOpenning(long openId) {
        String hql = "FROM ApplicationMaster am WHERE am.jobopening="+openId+"";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<ApplicationMaster> applicationData = query.getResultList();
        return applicationData;
    }
   
    
}
