package com.sun.tracy.userlistcase.servelet;

import com.sun.tracy.userlistcase.entity.PageMsg;
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

@WebServlet("/pageServelet")
public class PageServelet extends HttpServlet {
    int currentPage = 1;
    int rows = 5;

    private UserService service = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try{
            currentPage = Integer.parseInt(req.getParameter("currentPage"));
            rows = Integer.parseInt(req.getParameter("rows"));
        }catch (Exception e) {

        }
        Map<String, String[]> params = req.getParameterMap();



        PageMsg pageMsg = service.findByPage(currentPage, rows,params);
        System.out.println(pageMsg.toString());
        req.setAttribute("pageMsg",pageMsg);
        req.setAttribute("condition",params);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }
}