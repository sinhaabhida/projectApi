/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflowmanagement.dao;

import com.team2.workflowmanagement.model.User;
import java.util.List;

/**
 *
 * @author abhishek
 */
public interface UserDao {
    public void save(User user);
    
    public void update(User user);
    
    public void delete(long userId);
     
    public User get(long userId);
    
    public User findByEmail(String email);
    
    public List<User> listOfUsers();
}
