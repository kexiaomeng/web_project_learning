package com.sun.tracy.annotation;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * 注解版 web调用接口，实现后从service方法入口，需要在web-inf/web.xml下配置对应的关系
 */
@WebServlet(value = "/http")
public class MyHttpServlet extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getMethod();   // 获取请求方法
        String contextPath = req.getContextPath(); // 获取虚拟目录           重点
        String servelet = req.getServletPath(); // 获取servletpath
        req.getQueryString(); // 获取get的请求参数
        String UrI = req.getRequestURI(); // 获取请求的url 比较短，资源路径      重点
        req.getRequestURL(); // 获取请求的URl  比较长
        req.getProtocol();  // 获取http协议
        req.getRemoteAddr(); // 获取客户机的地址
        System.out.println(contextPath);
        System.out.println(servelet);
        System.out.println(UrI);


        Enumeration<String> headers = req.getHeaderNames();

        while (headers.hasMoreElements()) {
            System.out.println(headers.nextElement());
        }

        String a = req.getHeader("referer");
        if (a != null) {
            if (a.contains("hello")) {
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("崔希播放视频");
                System.out.println("崔希播放视频");
            }else {
                resp.setContentType("text/html;charset=utf-8");

                resp.getWriter().write("孙萌播放视频");

                System.out.println("孙萌播放视频" +
                        "");
            }
        }
        System.out.println(a);


        /**
         * get和post通用方法
         */

        System.out.println(req.getParameter("name"));
        System.out.println(Arrays.toString(req.getParameterValues("name")));


        Enumeration<String> he = req.getParameterNames();

        while (he.hasMoreElements()) {
            System.out.println(he.nextElement());
        }

        Map<String, String[]> map = req.getParameterMap();

        for (Map.Entry<String, String[]> maps : map.entrySet()) {
            System.out.println(maps.getKey()+" ,"+ Arrays.toString(maps.getValue()) );
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        /**
         * get和post通用方法
         */

        System.out.println(req.getParameter("name"));
        System.out.println(Arrays.toString(req.getParameterValues("name")));


        Enumeration<String> headers = req.getParameterNames();

        while (headers.hasMoreElements()) {
            System.out.println(headers.nextElement());
        }

        Map<String, String[]> map = req.getParameterMap();

        for (Map.Entry<String, String[]> maps : map.entrySet()) {
            System.out.println(maps.getKey()+" ,"+ Arrays.toString(maps.getValue()) );
        }
        /***************/



        BufferedReader reader = req.getReader();

        String line = null;
        while((line = reader.readLine()) != null) {
            System.out.println(line);

        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/dispatch");
        dispatcher.forward(req, resp);
    }
}
