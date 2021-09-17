package com.tracy.springmvc.annotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.attribute.standard.Destination;
import java.lang.reflect.Method;

@Controller
@RequestMapping("/hello")
public class MyController {

    /**
     * @RETURN 使用requestmapping时返回值为需要跳转的路径
     */
    @RequestMapping("h1")
    public String test(Model model) {
        model.addAttribute("msg","hello springmvcannotation_noxml");

        // 跳转地址 /hello.jsp
        return "index";
    }
    @RequestMapping(value = "h2",method = RequestMethod.GET)
    public String test2(String name) {
        System.out.println(name);

        // 跳转地址 /hello.jsp
        return "hello";
    }

    @RequestMapping(value = "h3", method = RequestMethod.POST)
    public String test3(@RequestParam(value = "username") String name, int age) {
        System.out.println(name+":"+age);

        // 跳转地址 /hello.jsp
        return "hello";
    }
}
