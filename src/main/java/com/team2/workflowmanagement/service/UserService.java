package com.team2.workflowmanagement.service;

import com.team2.workflowmanagement.dao.UserDao;
import com.team2.workflowmanagement.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDaoImpl;

    public boolean userRegistration(User data) {
//        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
//        Collection<? extends GrantedAuthority> grantedAuthorities=authentication.getAuthorities();
        User user = new User();

//        if(grantedAuthorities.toString().equals("[ADMIN]")) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode(data.getPassword());
        user.setId(data.getId());
        user.setActive(data.isActive());
        user.setDeleted(data.isDeleted());
        user.setEmail(data.getEmail());
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        user.setPassword(hashedPassword);
        user.setRole_id(data.getRole_id());
//            Role r;
//            r = roleRepository.findByName("developer");
//            if(r!=null){
//                System.out.println("Role Present");
//            }
        try {
            userDaoImpl.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
//        }else {
//return false;
    }

    public List<User> getUsers() {
//        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
//        Collection<? extends GrantedAuthority> grantedAuthorities=authentication.getAuthorities();
//        if(grantedAuthorities.toString().equals("[ADMIN]")){
        List<User> users = userDaoImpl.listOfUsers();
        return users;
//    }
//
//        else {
//            return Arrays.asList(null);
//    }
}
public boolean deleteUser(Long id){
//        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
//        Collection<? extends GrantedAuthority> grantedAuthorities=authentication.getAuthorities();
//        if(grantedAuthorities.toString().equals("[ADMIN]")){
            try {
                userDaoImpl.delete(id);
                return true;
            }catch (Exception e){
                return false;
            }

//        }else {
//            return false;
//        }

    }

    public User getUserService(Long id) {
//        Map<String, String> map = new HashMap<>();
//            User user = userRepository.findById(id);
//            map.put("firstName", user.getName());
//            map.put("lastName", user.getLast_name());
//            map.put("email", user.getEmail());
//            map.put("password",user.getPassword());
//            List<Role> roles = user.getRoles();
//            map.put("role", roles.get(0).getName());
//            return map;
         User user = userDaoImpl.get(id);
         return user;
    }
    public boolean updateUserService(User data){
//    	System.out.println(userData.getRole());
//           User user= userRepository.getOne(userData.getId());
//           user.setName(userData.getFirstName());
//           user.setLast_name(userData.getLastName());
//           user.setEmail(userData.getEmail());
//           System.out.println(user.getRoles());
//           user.setRoles(Arrays.asList(new  Role(userData.getRole())));
           try{
//        	   userRepository.delete(id);
//        	   userRepository.save(user);
//        	   userRepository.fi
                   userDaoImpl.update(data);
//           userRepository.save(user);
           return true;

        }catch (Exception e){
            System.out.println(e);
return false;
        }
    }


    public User getProfileService(String email){
       User user=userDaoImpl.findByEmail(email);
//       Data userData=new Data();
//       userData.setFirstName(user.getName());
//       userData.setLastName(user.getLast_name());
//       userData.setEmail(user.getEmail());
//       userData.setId(user.getId());
//       userData.setRole(user.getRoles().get(0).getName());
       return user;
    }
}
