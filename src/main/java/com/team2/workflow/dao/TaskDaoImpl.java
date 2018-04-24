/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.dao;

import com.team2.workflow.model.Task;
import com.team2.workflow.model.Task.Status;
import com.team2.workflow.model.User;
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
public class TaskDaoImpl implements TaskDao{

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public long addTask(Task task) {
        Session session = sessionFactory.getCurrentSession();
        String hqlAsignee = "FROM User U WHERE U.email='" + task.getAsignee().getEmail() + "' ";
        String hqlCreator = "FROM User U WHERE U.email='" + task.getCreator().getEmail() + "' ";
        Query queryAsignee = session.createQuery(hqlAsignee);
        Query queryCreator = session.createQuery(hqlCreator);
        try {
               User userAsignee = (User) queryAsignee.list().get(0);
            User userCreator = (User) queryCreator.list().get(0);
            if (userAsignee != null && userCreator != null) {
                task.setAsignee(userAsignee);
                task.setCreator(userCreator);
                session.save(task);
                return task.getTaskId();
            }
        } catch (Exception E) {
            System.out.println("Index Exception Catched");
        }
        return 0;
}

    @Override
    public void changeTaskStatus(long taskId, Task.Status status) {
      Session session = sessionFactory.getCurrentSession();
      Task task2 = session.byId(Task.class).load(taskId);
      task2.setTaskStatus(status);
      session.flush();
    }

    @Override
    public List<Task> getAllTask() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Task> cq = cb.createQuery(Task.class);
      Root<Task> root = cq.from(Task.class);
      cq.select(root);
      Query<Task> query = session.createQuery(cq);
      return query.getResultList();
    }

    @Override
    public Task getTaskById(long taskId) {
        return sessionFactory.getCurrentSession().get(Task.class,taskId);
    }

    @Override
    public List<Task> getListOfAssignedTaskFor(long userId) {
        String hql = "FROM Task T WHERE T.asignee="+userId+"AND T.status="+Status.valueOf("InProgress")+"";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        List<Task> tasks = query.list();
        return tasks;
    }
    
}
