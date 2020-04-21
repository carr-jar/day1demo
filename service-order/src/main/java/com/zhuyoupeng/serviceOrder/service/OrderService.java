package com.zhuyoupeng.serviceOrder.service;


import com.zhuyoupeng.serviceUserInterface.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public Order getOrderById(Integer id){
        Order order = new Order();
        order.setId(id);
        order.setName("第一个订单");
        return order;
    }
}
