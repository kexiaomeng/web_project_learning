package com.sun.tracy.userlistcase.servelet;

import com.sun.tracy.userlistcase.entity.User;
import com.sun.tracy.userlistcase.service.UserService;
import com.sun.tracy.userlistcase.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServelet")
public class LoginServelet extends HttpServlet {
    private UserService service = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String checkCodeSession = (String)request.getSession().getAttribute("checkCode_session");
        request.getSession().removeAttribute("checkCode_session");
        String userName = request.getParameter("name");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("verifycode");

        if (checkCodeSession != null && checkCodeSession.equalsIgnoreCase(checkCode)) {

            User searchUser = service.findUser(userName, password);
            if (searchUser != null) {
                request.getSession().setAttribute("user",userName);
                response.sendRedirect(request.getContextPath()+"/search.jsp");
                System.out.println("登录成功");

            }else{
                request.setAttribute("login_msg","用户名或密码错误");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
                System.out.println("登录失败");

            }
        }else{
            request.setAttribute("login_msg","验证码错误");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
            System.out.println("验证码错误");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
