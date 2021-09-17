package com.tracy.springmvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView view = new ModelAndView();
        view.addObject("msg", "hello mvc");
        // 会自动拼接springmvc.xml配置文件里配置的前缀和后缀
        view.setViewName("hello");
        return view;
    }
}
