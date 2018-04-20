/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team2.workflow.dao;

import com.team2.workflow.model.User;
import java.util.List;

/**
 *
 * @author abhishek
 */

public interface UserDao {
    public long save(User user);
    
    public void update(long id, User user);
    
    public void delete(long userId);
     
    public User get(long userId);
    
    public User findByEmail(String email);
    
    public List<User> list();
}
