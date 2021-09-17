package com.sun.tracy.userlistcase.servelet;

import com.sun.tracy.userlistcase.service.UserService;
import com.sun.tracy.userlistcase.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteSelectServelet")
public class DeleteSelectServelet extends HttpServlet {

    private UserService service = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String ids[] = req.getParameterValues("uid");
        service.deleteSelected(ids);

        resp.sendRedirect(req.getContextPath()+"/list");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}