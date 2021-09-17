package com.tracy.ssm.controller;

import com.tracy.ssm.domain.User;
import com.tracy.ssm.exception.AgeException;
import com.tracy.ssm.exception.MyException;
import com.tracy.ssm.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IntercepterController {

    @RequestMapping("/intercepter.do")
    public ModelAndView exception(User user) throws MyException {
        System.out.println("执行controller的方法");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", user.getName());
        modelAndView.setViewName("add");
        return modelAndView;
    }
}
