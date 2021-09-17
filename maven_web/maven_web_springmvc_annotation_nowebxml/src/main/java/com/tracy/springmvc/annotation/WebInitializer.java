package com.tracy.springmvc.annotation;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

// 相当于web.xml,容器会自动发现
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//
//        context.register(SpringMvcConfigruration.class);
//        context.setServletContext(servletContext);
//
//        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
//
//        servlet.addMapping("/");
//        servlet.setLoadOnStartup(1);

        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(SpringMvcConfigruration.class);


        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
        servlet.addMapping("/");//添加上下文路径地址
        servlet.setLoadOnStartup(1);//最优先启动
        servlet.setAsyncSupported(true); //设置允许异步线程

        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("utf-8");
        filter.setForceRequestEncoding(true);
        filter.setForceResponseEncoding(true);
        //注册Filter
        FilterRegistration.Dynamic dynamic = servletContext.addFilter("myFilter",
                filter);
        dynamic.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*"); //映射Filter

    }
}
