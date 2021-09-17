package com.tracy.springmvc.annotation.controller;

import com.tracy.springmvc.annotation.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/datadeal")
public class DataDealController {

    /**
     * @RETURN 使用requestmapping时返回值为需要跳转的路径
     */
    @RequestMapping("h1")
    public String test(User user) {
        System.out.println(user);

        // 跳转地址 /hello.jsp
        return "hello";
    }


    /**
     */
    @ResponseBody
    @RequestMapping("h2")
    public User test1(User user) {
        System.out.println(user);

        return user;
    }

}
