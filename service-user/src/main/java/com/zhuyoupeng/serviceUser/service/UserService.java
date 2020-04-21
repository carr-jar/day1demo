package com.zhuyoupeng.serviceUser.service;


import com.zhuyoupeng.serviceUserInterface.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String getUsernameById(Integer id){
        User user = new User();
        user.setId(id);
        user.setUsername("UserService:"+id);
        return user.getUsername();
    }

    public User getUserById(Integer id){
        User user = new User();
        user.setId(id);
        user.setUsername("lsii");
        return user;
    }
}
