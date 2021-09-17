package com.sun.tracy.userlistcase.servelet;

import com.sun.tracy.userlistcase.entity.User;
import com.sun.tracy.userlistcase.service.UserService;
import com.sun.tracy.userlistcase.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/addUserServelet")
public class AddUserServelet extends HttpServlet {

    private UserService service = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> userMap = req.getParameterMap();

        User user = new User();
        try {
            BeanUtils.populate(user, userMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        service.addUser(user);

        resp.sendRedirect(req.getContextPath()+"/list");
    }
}