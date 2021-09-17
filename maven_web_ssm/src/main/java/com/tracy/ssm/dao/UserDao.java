package com.tracy.ssm.dao;

import com.tracy.ssm.domain.User;

import java.util.List;

public interface UserDao {
     List<User> getAllUser();

     int insertUser(User user);
}
