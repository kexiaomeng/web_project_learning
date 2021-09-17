package com.sun.tracy.userlistcase.filter;

import com.sun.jndi.toolkit.url.Uri;
import com.sun.tracy.userlistcase.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = "/*",dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        String uri = request.getRequestURI();
        System.out.println("搜索");

        if(uri.contains("/login.jsp") || uri.contains("/checkCodeServlet")
                || uri.contains("/loginServelet")
                || uri.contains(".css")
                || uri.contains("/js/")
//                || uri.contains("/css/")
//                || uri.contains("/js/")
                || uri.contains("/fonts/")) {
            System.out.println(uri);
            chain.doFilter(request, resp);
        }else {
            HttpSession session = request.getSession();
            String username = (String)session.getAttribute("user");
            if (username != null) {
                System.out.println("放行");
                chain.doFilter(request, resp);
            }else {
                System.out.println("不放行");

                request.setAttribute("login_msg", "您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }
//        chain.doFilter(request, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
