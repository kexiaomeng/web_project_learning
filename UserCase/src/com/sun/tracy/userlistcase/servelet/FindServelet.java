package com.sun.tracy.userlistcase.servelet;


import com.sun.tracy.userlistcase.entity.User;
import com.sun.tracy.userlistcase.service.UserService;
import com.sun.tracy.userlistcase.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/findServelet")
public class FindServelet extends HttpServlet {
    private UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");

        HttpSession session = req.getSession();
        User user = service.findUserById(Integer.parseInt(req.getParameter("id")));
        session.setAttribute("user", user);

        resp.setContentType("text/html;charset=utf-8");
        resp.sendRedirect(req.getContextPath()+"/update.jsp");
    }
}
