package com.tracy.ssm.controller;

import com.tracy.ssm.domain.User;
import com.tracy.ssm.exception.AgeException;
import com.tracy.ssm.exception.MyException;
import com.tracy.ssm.exception.NameException;
import com.tracy.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ExceptionController {





    @RequestMapping("/some.do")
    public ModelAndView exception(User user) throws MyException {
        if (!user.getName().equals("孙萌")) {
            throw new NameException("姓名应该为孙萌");
        }

        if (user.getAge() == null || user.getAge() > 100) {
            throw  new AgeException("年龄应该存在且小于100");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", user.getName());
        modelAndView.setViewName("add");
        return modelAndView;
    }
}
