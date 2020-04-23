package com.zhuyoupeng.serviceOrder.service;


import com.zhuyoupeng.serviceOrder.mapper.OrderMapper;
import com.zhuyoupeng.serviceUserInterface.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    public Order getOrderById(Integer id){
//        Order order = new Order();
//        order.setId(id);
//        order.setName("第一个订单");
        Order order = orderMapper.getOrderById(id);
        return order;
    }
}
