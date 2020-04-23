package com.zhuyoupeng.serviceUser.service;


import com.zhuyoupeng.serviceUser.mapper.UserMapper;
import com.zhuyoupeng.serviceUserInterface.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public String getUsernameById(Integer id){
        User user = new User();
        user.setId(id);
        user.setUsername("UserService:"+id);
        return user.getUsername();
    }

    public User getUserById(Integer id){
//        User user = new User();
////        user.setId(id);
////        user.setUsername("lsii");
        User user = userMapper.getUserById(id);
        return user;
    }
}
