package com.sun.tracy;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/loginServelet")
public class LoginServelet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkCodeSession = (String)request.getSession().getAttribute("checkCode_session");
        request.getSession().removeAttribute("checkCode_session");

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        if (checkCodeSession != null && checkCodeSession.equalsIgnoreCase(checkCode)) {

            if ("sunmeng".equalsIgnoreCase(userName) && "123456".equalsIgnoreCase(password)) {
                request.getSession().setAttribute("user",userName);
                response.sendRedirect(request.getContextPath()+"/success");
                System.out.println("登录成功");

            }else{
                request.setAttribute("login_error","用户名或密码错误");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
                System.out.println("登录失败");

            }
        }else{
            request.setAttribute("cc_error","验证码错误");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            System.out.println("验证码错误");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
