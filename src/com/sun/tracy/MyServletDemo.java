package com.sun.tracy;

import javax.servlet.*;
import java.io.IOException;

/**
 * web调用接口，实现后从service方法入口，需要在web-inf/web.xml下配置对应的关系
 */
public class MyServletDemo implements Servlet {
    @Override
    // 初始化时执行
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service...");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override

    public void destroy() {

        System.out.println("destory....");

    }
}
