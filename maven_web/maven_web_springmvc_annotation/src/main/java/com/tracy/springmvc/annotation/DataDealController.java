package com.tracy.springmvc.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

}
