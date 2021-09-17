package com.tracy.ssm.service;

import com.tracy.ssm.dao.UserDao;
import com.tracy.ssm.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAllUsers() {
        System.out.println("查询所有用户");
        return userDao.getAllUser();
    }

    @Override
    public int insertUser(User user) {
        System.out.println("插入一个用户");
        System.out.println(user);
        return userDao.insertUser(user);
    }
}
