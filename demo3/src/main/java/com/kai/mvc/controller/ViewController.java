package com.kai.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/12/6
 **/
@Controller
public class ViewController {

    // thymeleaf视图
    @RequestMapping("/testThymeleafView")
    public String testView() {
        return "success";
    }


    /**
     * 转发视图 InternalResourceView
     *      1.会截掉forward前缀，然后转发到 /testThymeleafView 方法 这个过程是转发视图InternalResourceView创建的
     *      2.再次请求 /testThymeleafView 是thymeleaf视图创建的
     */
    @RequestMapping("/testForward")
    public String testForward() {

        return "forward:/testThymeleafView";
    }

    /**
     * 重定向视图 RedirectView
     *      1.当控制器方法中所设置的视图名称以"redirect:"为前缀时，创建RedirectView视图，此时的视图名称不
     *          会被SpringMVC配置文件中所配置的视图解析器解析，而是会将前缀"redirect:"去掉，
     *      2.剩余部分作为最终路径通过重定向的方式实现跳转 thymeleaf视图创建的
     */
    @RequestMapping("/testRedirect")
    public String testRedirect() {
        return "redirect:/testThymeleafView";
    }
}
