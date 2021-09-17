package com.tracy.ssm.service;

import com.tracy.ssm.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    int insertUser(User user);
}
