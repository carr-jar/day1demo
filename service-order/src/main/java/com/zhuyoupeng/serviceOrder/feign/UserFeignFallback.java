package com.zhuyoupeng.serviceOrder.feign;

import com.zhuyoupeng.serviceUserInterface.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignFallback implements UserFeignClient{
    @Override
    public User getUserById(Integer id) {
        User user1 = new User();
        user1.setUsername("失败失败");
        return user1;
    }

    @Override
    public User getUserByUser(User user) {
        User user1 = new User();
        user1.setUsername("失败失败");
        return user1;
    }

    @Override
    public String getUsernameById(Integer id) {
        return null;
    }
}
