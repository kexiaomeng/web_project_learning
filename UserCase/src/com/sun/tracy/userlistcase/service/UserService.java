package com.sun.tracy.userlistcase.service;

import com.sun.tracy.userlistcase.entity.PageMsg;
import com.sun.tracy.userlistcase.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAll();

    User findUser(String userName, String password);
    User findUserById(Integer id);

    void addUser(User user);

    void deleteUser(Integer id);
    void updateUser(User user);
    void deleteSelected(String ids[]);

    PageMsg findByPage(int currentPage, int rows, Map<String, String[]> params);
}
