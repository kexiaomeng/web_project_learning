package com.sun.tracy.annotation;

import sun.net.www.content.text.Generic;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * 注解版 web调用接口，实现后从service方法入口，需要在web-inf/web.xml下配置对应的关系
 */
@WebServlet(value = "/annotation")
public class MyServlet extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello servlet");
    }


}
