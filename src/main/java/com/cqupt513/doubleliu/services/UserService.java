package com.cqupt513.doubleliu.services;

import com.cqupt513.doubleliu.pojo.User;

public interface UserService {
    User findByUsernameAndPassword(String username, String password);
}
