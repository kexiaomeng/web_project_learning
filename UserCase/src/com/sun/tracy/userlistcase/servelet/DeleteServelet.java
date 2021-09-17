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
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/deleteServelet")
public class DeleteServelet extends HttpServlet {

    private UserService service = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        Integer id = Integer.parseInt(req.getParameter("id"));

        service.deleteUser(id);

        resp.sendRedirect(req.getContextPath()+"/list");
    }
}