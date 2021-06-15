package com.cqupt513.doubleliu.services;

import com.cqupt513.doubleliu.mapper.UserMapper;
import com.cqupt513.doubleliu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userMapper.findByUsernameAndPassword(username,password);
    }
}
