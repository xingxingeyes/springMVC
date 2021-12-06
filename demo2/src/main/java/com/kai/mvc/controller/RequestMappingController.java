package com.kai.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.Request;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/12/5
 **/
@Controller
// @RequestMapping("hello")
public class RequestMappingController {

    // 表示满足以下多个请求地址都可以访问此方法
    // method 属性可以不写 默认所有请求方式都支持，如果配置就只支持配置的请求方式
    @RequestMapping(
            value = {"/testRequestMapping", "test"},
            method = {RequestMethod.GET, RequestMethod.POST},
            params = {"username"}
    )
    public String success() {
        return "success";
    }


    @GetMapping("/testGetMapping")
    public String testGetMapping() {
        return "success";
    }

    @RequestMapping(value = "/testPut", method = RequestMethod.PUT)
    public String testPut() {
        return "success";
    }

    @RequestMapping(
            value = "/testParamsAndHeaders",
            params = {"username", "password!=123456"}, // 里面的参数必须同时都匹配 请求必须要有username和password!=123456
            headers = {"Host=localhost:8080"} // 表示请求头中必须有 Host=localhost:8080 才能匹配此方法
    )
    public String testParamsAndHeaders() {
        return "success";
    }

    // ant风格的路径 可以做模糊匹配
    // @RequestMapping("/a?a/testAnt") // ant风格的路径 ? 表示任意的单个字符
    // @RequestMapping("/a*a/testAnt") // ant风格的路径 * 表示的0个或多个字符
    @RequestMapping("/**/testAnt") // ant风格的路径 ** 表示任意的一层或多层目录 在使用**时，只能使用/**/xxx的方式
    public String testAnt() {
        return "success";
    }

    @RequestMapping("/testPath/{id}/{username}") // {}占位符 浏览器中占位符中参数必须有值
    public String testPath(@PathVariable("id") Integer id, @PathVariable("username")String username) { // @PathVariable("id")表示将占位符中的id在佛那个赋值给形参
        System.out.println("id:" + id +" username:"+username);
        return "success";
    }


}
