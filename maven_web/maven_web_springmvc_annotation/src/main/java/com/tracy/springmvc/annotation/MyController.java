package com.tracy.springmvc.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class MyController {

    /**
     * @RETURN 使用requestmapping时返回值为需要跳转的路径
     */
    @RequestMapping("h1")
    public String test(Model model) {
        model.addAttribute("msg","hello springmvcannotation");

        // 跳转地址 /hello.jsp
        return "hello";
    }
    @RequestMapping("h2")
    public String test2(String name) {
        System.out.println(name);

        // 跳转地址 /hello.jsp
        return "hello";
    }

    @RequestMapping("h3")
    public String test3(@RequestParam(value = "username") String name) {
        System.out.println(name);

        // 跳转地址 /hello.jsp
        return "hello";
    }
}
