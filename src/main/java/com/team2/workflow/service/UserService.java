package com.team2.workflow.service;

import com.team2.workflow.dao.UserDao;
import com.team2.workflow.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    UserDao userDaoImpl;

    @Transactional
    public long userRegistration(User data) {
    return userDaoImpl.save(data);
    }

    public User getUserService(Long id) {
         User user = userDaoImpl.get(id);
         return user;
    }
    
    public List<User> getUsers() {
         return userDaoImpl.list();
    }
    
    @Transactional
    public void updateUserService(long id ,User data){
        userDaoImpl.update(id, data);
    }


    public User getProfileService(String email){
       User user=userDaoImpl.findByEmail(email);
       return user;
    }
    
    @Transactional
    public void deleteUser(long id){
        userDaoImpl.delete(id);
    }
}
