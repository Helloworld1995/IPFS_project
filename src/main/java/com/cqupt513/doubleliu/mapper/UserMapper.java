package com.cqupt513.doubleliu.mapper;

import com.cqupt513.doubleliu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where name=#{username} and password=#{password}")
    User findByUsernameAndPassword(String username, String password);
}
