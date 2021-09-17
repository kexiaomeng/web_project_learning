package com.tracy.ssm.controller;

import com.tracy.ssm.domain.User;
import com.tracy.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/findAllUser.do")
    public List<User> findAllUser() {
        return userService.getAllUsers();
    }

    @RequestMapping("/user/addUser.do")
    public ModelAndView addUser(User user) {
        user.setName("ssm");
        String tips = "注册成功";
        int i = userService.insertUser(user);
        if (i > 0) {
            tips = user.getName()+tips;
        }else {
            tips = user.getName()+"注册失败";

        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", tips);
        modelAndView.addObject(user.toString());
        modelAndView.setViewName("add");
        return modelAndView;
    }
}
