package com.sun.tracy.userlistcase.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Mylistener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("init");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("destory");
    }
}
