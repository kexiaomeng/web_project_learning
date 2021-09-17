package com.tracy.springmvc.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestfulController {

    @RequestMapping("/rest")
    @ResponseBody
    public String restController(Model model) {
        model.addAttribute("msg","hello rest");
        return "hello";
    }


    @RequestMapping("/rest/{a}/{b}")
    public String restController(@PathVariable int a, @PathVariable int b, Model model) {
        int result = a+b;
        model.addAttribute("msg","hello rest:"+result);
        return "hello";
    }
}
