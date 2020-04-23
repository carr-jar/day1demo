package com.zhuyoupeng.serviceOrder.mapper;

import com.zhuyoupeng.serviceUserInterface.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface OrderMapper {

    @Select("SELECT * FROM `order` o LEFT JOIN USER u ON o.`id`=u.`uid` where id=#{id}")
    Order getOrderById(Integer id);
}
