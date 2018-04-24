/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.dao;

import com.team2.workflow.model.JobCategory;
import com.team2.workflow.model.JobOpening;
import com.team2.workflow.model.Role;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abhishek
 */
@Repository
public class JobOpeningDaoImpl implements JobOpeningDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public long addOpening(JobOpening jobOpening) {
        JobCategory category;
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM JobCategory j WHERE j.categoryName='" + jobOpening.getJobCategory().getCategoryName() +"' ";
        Query query = session.createQuery(hql);
        try {
            category = (JobCategory) query.list().get(0);
            if (category != null) {
                jobOpening.setJobCategory(category);
                session.save(jobOpening);
                return jobOpening.getId();
            }
        } catch (Exception E) {
            System.out.println("Index Exception Catched");
        }
        session.save(jobOpening);
        session.flush();
        return jobOpening.getId();
    }

    @Override
    public void updateOpening(long openId, JobOpening jobOpening) {
        Session session = sessionFactory.getCurrentSession();
        JobOpening jobOpening2 = session.byId(JobOpening.class).load(openId);
        jobOpening2.setJobCategory(jobOpening.getJobCategory());
        jobOpening2.setJobName(jobOpening.getJobName());
        jobOpening2.setJobOpenningDate(jobOpening.getJobOpenningDate());
        jobOpening2.setJobClosingDate(jobOpening.getJobClosingDate());
        jobOpening2.setMaxExp(jobOpening.getMaxExp());
        jobOpening2.setMinExp(jobOpening.getMinExp());
        jobOpening2.setStatus(jobOpening.isStatus());
        session.flush();
    }

    @Override
    public void deleteOpening(long openId) {
        Session session = sessionFactory.getCurrentSession();
        JobOpening jobOpening = session.byId(JobOpening.class).load(openId);
        session.remove(jobOpening);
    }

    @Override
    public List<JobOpening> getAllOpenings() {
        LocalDate date = java.time.LocalDate.now();
        String hql = "FROM JobOpening j WHERE j.jobClosingDate>=" + date + "AND j.status=" + true + "";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        List<JobOpening> openings = query.list();
        return openings;
    }

}
