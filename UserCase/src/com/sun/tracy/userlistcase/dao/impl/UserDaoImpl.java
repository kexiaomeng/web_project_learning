package com.sun.tracy.userlistcase.dao.impl;

import com.sun.tracy.userlistcase.dao.DuridUtils;
import com.sun.tracy.userlistcase.dao.UserDao;
import com.sun.tracy.userlistcase.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(DuridUtils.getDataSource());

    private String findSql = "select * from user";
    private String findUser = "select * from user where name = ? and password = ?";
    private String addUser = "insert into user values(null,?,?,?,?,?,?,null) ";
    private String deleteUser = "delete from user where id=? ";
    private String findUserById = "select * from user where id=?";
    private String updateUser = "update user set qq=?,age=?,email=?,address=? where id=?";
    private String findTotalSql = "select count(1) from user where 1=1 ";
    private String findByPage = "select * from user where 1=1 ";

    @Override
    public List<User> findAll() {
        return template.query(findSql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findUser(String userName, String password) {

        try {
            System.out.println(userName+"   "+password);
            return template.queryForObject(findUser,new BeanPropertyRowMapper<>(User.class),userName, password);
        }catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public void addUser(User user) {
        try {
            System.out.println(user.toString());
            template.update(addUser, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(),user.getEmail());
            System.out.println("成功");

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("添加失败");
        }
    }

    @Override
    public User findUserById(Integer id) {
        try {
            return template.queryForObject(findUserById,new BeanPropertyRowMapper<>(User.class),id);
        }catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public void deleteUser(Integer id) {
        try {
            System.out.println(id);
            template.update(deleteUser, id);
            System.out.println("成功");

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除失败");
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            System.out.println(user.toString());
            template.update(updateUser, user.getQq(), user.getAge(), user.getEmail(), user.getAddress(), user.getId());
            System.out.println("成功");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int findTotal(Map<String, String[]> params) {
        StringBuilder sb = new StringBuilder();
        sb.append(findTotalSql);
        List<String> values = new ArrayList<>();
        for (Map.Entry<String,String[]> param : params.entrySet()) {
            //排除分页条件参数
            if("currentPage".equals(param.getKey()) || "rows".equals(param.getKey())){
                continue;
            }
            String value = param.getValue()[0];
            if (value != null && "" != value) {
                sb.append(" and "+ param.getKey() +" like ?" );
                values.add("%"+value+"%");
            }
        }
        System.out.println(sb.toString());
        System.out.println(values);

        return template.queryForObject(sb.toString(),Integer.class,values.toArray());
    }

    @Override
    public List<User> findByPage(int currentPage, int rows, Map<String, String[]> params) {
        StringBuilder sb = new StringBuilder();
        sb.append(findByPage);
        List<Object> values = new ArrayList<>();
        for (Map.Entry<String,String[]> param : params.entrySet()) {
            //排除分页条件参数
            if("currentPage".equals(param.getKey()) || "rows".equals(param.getKey())){
                continue;
            }
            String value = param.getValue()[0];
            if (value != null && "" != value) {
                sb.append(" and "+ param.getKey() +" like ?" );
                values.add("%"+value+"%");
            }
        }
        sb.append(" limit ? , ?");
        System.out.println(sb.toString());
        values.add((currentPage-1)*rows);
        values.add(rows);
        System.out.println(values);

        return template.query(sb.toString(), new BeanPropertyRowMapper<>(User.class),values.toArray());
    }
}
