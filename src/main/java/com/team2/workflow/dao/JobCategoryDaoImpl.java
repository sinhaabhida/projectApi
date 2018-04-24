/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.dao;

import com.team2.workflow.model.JobCategory;
import com.team2.workflow.model.Task;
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
public class JobCategoryDaoImpl implements JobCategoryDao{

     @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public long addCategory(JobCategory jobCategory) {
    sessionFactory.getCurrentSession().save(jobCategory);
    return jobCategory.getId();
    }

    @Override
    public void updateCategory(long catId, JobCategory jobCategory) {
        Session session =sessionFactory.getCurrentSession();
        JobCategory jobCat2 = session.byId(JobCategory.class).load(catId);
        jobCat2.setCategoryName(jobCategory.getCategoryName());
        jobCat2.setCategoryDescription(jobCategory.getCategoryDescription());
        jobCat2.setStatus(jobCategory.getStatus());
        session.flush();
    }

    @Override
    public void deleteCategory(long catId) {
        Session session = sessionFactory.getCurrentSession();
        JobCategory jobCategory = session.byId(JobCategory.class).load(catId);
        session.remove(jobCategory);
    }

    @Override
    public List<JobCategory> getAllCategory() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<JobCategory> cq = cb.createQuery(JobCategory.class);
      Root<JobCategory> root = cq.from(JobCategory.class);
      cq.select(root);
      Query<JobCategory> query = session.createQuery(cq);
      return query.getResultList();
    }
    
}
