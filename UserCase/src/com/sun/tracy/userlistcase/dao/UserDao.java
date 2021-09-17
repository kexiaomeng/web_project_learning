package com.sun.tracy.userlistcase.dao;

import com.sun.tracy.userlistcase.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> findAll() ;
    User findUser(String userName, String password);
    void addUser(User user);
    User findUserById(Integer id);

    void deleteUser(Integer id);
    void updateUser(User user);

    int findTotal(Map<String, String[]> params);

    List<User> findByPage(int currentPage, int rows, Map<String, String[]> params);
}
