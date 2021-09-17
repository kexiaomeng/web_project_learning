package com.sun.tracy.userlistcase.service.impl;

import com.sun.tracy.userlistcase.dao.UserDao;
import com.sun.tracy.userlistcase.dao.impl.UserDaoImpl;
import com.sun.tracy.userlistcase.entity.PageMsg;
import com.sun.tracy.userlistcase.entity.User;
import com.sun.tracy.userlistcase.service.UserService;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {

        return dao.findAll();
    }

    @Override
    public User findUser(String userName, String password) {
        return dao.findUser(userName, password);
    }

    @Override
    public User findUserById(Integer id) {
        return dao.findUserById(id);
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        dao.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void deleteSelected(String[] ids) {
        if (ids == null) {
            return;
        }
        for (String id : ids) {
            dao.deleteUser(Integer.parseInt(id));
        }
    }

    @Override
    public PageMsg findByPage(int currentPage, int rows, Map<String, String[]> params) {
        PageMsg<User> pageMsg = new PageMsg<>();
        pageMsg.setCurrentPage(currentPage);
        pageMsg.setRows(rows);

        int totalCount = dao.findTotal(params);
        pageMsg.setTotalCount(totalCount);
        List<User> users = dao.findByPage(currentPage, rows,params);
        pageMsg.setMsgs(users);
        pageMsg.setTotalPage(totalCount%rows == 0 ? totalCount/rows : totalCount/rows + 1);
        return pageMsg;
    }


}
