package com.kai.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/12/8
 **/
@Controller
public class TestController {

    @RequestMapping("/**/testInterceptor")
    public String testInterceptor() {
        return "success";
    }

}
