package com.kai.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/12/3
 **/
@Controller
public class HelloController {

    // "/" -->/WEB-INF/templates/index.html
    @RequestMapping("/")
    public String index() {
        // 返回视图名称
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget() {
        return "target";
    }

}
