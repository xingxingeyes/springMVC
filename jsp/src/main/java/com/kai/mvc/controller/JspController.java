package com.kai.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/12/6
 **/
@Controller
public class JspController {

    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
