package com.zhuyoupeng.serviceUser.mapper;

import com.zhuyoupeng.serviceUserInterface.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserMapper {
    @Select("select * from user where uid =#{id}")
    User getUserById(Integer id);
}
