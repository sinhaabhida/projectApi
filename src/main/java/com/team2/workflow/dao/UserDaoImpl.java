/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.dao;

import com.team2.workflow.model.Role;
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
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(User user) {
        Role role;
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Role R WHERE R.role='" + user.getRole().getRole() + "' ";
        Query query = session.createQuery(hql);
        try {
            role = (Role) query.list().get(0);
            if (role != null) {
                user.setRole(role);
                session.save(user);
                return user.getId();
            }
        } catch (Exception E) {
            System.out.println("Index Exception Catched");
        }
        session.save(user);
        session.flush();
        return user.getId();
    }

    @Override
    public void update(long id, User user) {
        Session session = sessionFactory.getCurrentSession();
        User user2 = session.byId(User.class).load(id);
        user2.setActive(user.isActive());
        user2.setDeleted(user.isDeleted());
        user2.setEmail(user.getEmail());
        user2.setDesignation(user.getDesignation());
        user2.setFirstName(user.getFirstName());
        user2.setLastName(user.getLastName());
        String hql = "FROM Role R WHERE R.role='" + user.getRole().getRole() + "' ";
        Query query = session.createQuery(hql);
        try {
            Role role = (Role) query.list().get(0);
            if (role != null) {
                user2.setRole(role);
                session.flush();
                return;
            }
        } catch (Exception E) {
            System.out.println("Index Exception Catched");
        }
        user2.setRole(user.getRole());
        session.flush();

    }

    @Override
    public void delete(long userId) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.byId(User.class).load(userId);
        session.delete(user);
    }

    @Override
    public User get(long userId) {
        return sessionFactory.getCurrentSession().get(User.class, userId);
    }

    @Override
    public User findByEmail(String email) {
        String hql = "FROM User U WHERE U.email='" + email + "'";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        User user = (User) query.list().get(0);
        return user;
    }

    @Override
    public List<User> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        Query<User> query = session.createQuery(cq);
        return query.getResultList();
    }

}