package com.tracy.springmvc.annotation.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器和过滤器的区别：
 * 1. 拦截器是springmvc框架提供的，过滤器是servlet提供的
 * 2. 过滤器侧重对数据过滤，如请求参数，返回参数，侧重于对数据的过滤，拦截器侧重于对请求的验证，能截断请求
 * 3. 过滤器会在拦截器之前执行
 * 4. 过滤器是tomcat创建的， 拦截器是sprimgmvc容器创建的
 * 5.
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     *  主要用的方法
     * @param request
     * @param response
     * @param handler 被拦截的控制器
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("interceptor 的 prehandle方法");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("interceptor 的 postHandle方法");

    }

    /**
     * 一般用来进行资源回收
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("interceptor 的afterCompletion方法");

    }
}
