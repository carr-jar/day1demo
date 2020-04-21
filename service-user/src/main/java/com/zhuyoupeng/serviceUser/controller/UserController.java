package com.zhuyoupeng.serviceUser.controller;


import com.zhuyoupeng.serviceUser.service.UserService;
import com.zhuyoupeng.serviceUserInterface.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("getUsernameById")
    public String getUsernameById(@RequestParam("id") Integer id){ //根据id获取用户名称
        log.info("userId:{}",id);
        return service.getUsernameById(id);
    }

    @RequestMapping("getUserByUser")
    public User getUserByUser(@RequestBody User user){ //根据用户对象返回用户对象
        log.info("userId:{}",user.getId());
        return service.getUserById(user.getId());
    }

    @RequestMapping("getUserById")
    public User getUserById(@RequestParam("id") Integer id){  //根据id获取用户对象
        log.info("userId:{}",id);
        return service.getUserById(id);
    }
}
