package com.zhuyoupeng.serviceOrder.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhuyoupeng.serviceOrder.feign.UserFeignClient;
import com.zhuyoupeng.serviceOrder.service.OrderService;
import com.zhuyoupeng.serviceUserInterface.Order;
import com.zhuyoupeng.serviceUserInterface.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserFeignClient userFeignClient;

    @RequestMapping("getOrderById")
    public Order getOrderById(@RequestParam("id") Integer id){
        Order order = service.getOrderById(id);
        User user = restTemplate.getForObject("http://service-user/user/getUserById?id=" + order.getId(), User.class);
        order.setUsername(user.getUsername());
        return order;
    }

    @RequestMapping("getOrderById2")
    @HystrixCommand(fallbackMethod = "getUserByIdFallback")
    public Order getOrderById2(@RequestParam("id") Integer id){
        Order order = service.getOrderById(id);
        User user = userFeignClient.getUserById(id);
        order.setUsername(user.getUsername());
        return order;
    }

    /**
     * 通过对象
     * @param id
     * @return
     */
    @RequestMapping("getOrderById3")
    public Order getOrderById3(@RequestParam("id") Integer id){
        Order order = service.getOrderById(id);
        User user1 = new User();
        user1.setId(id);
        User user = userFeignClient.getUserByUser(user1);
        order.setUsername(user.getUsername());
        return order;
    }

    /**
     * 方法参数与getOrderById方法参数相同
     * @param id
     * @return
     */
    public Order getUserByIdFallback(Integer id){
        Order order = service.getOrderById(id);
        order.setUsername("熔断熔断");
        return order;
    }
}
