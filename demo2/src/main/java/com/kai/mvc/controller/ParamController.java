package com.kai.mvc.controller;

import com.kai.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/12/5
 **/
@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
    // 形参位置的request表示当前请求
    public String testServletAPI(HttpServletRequest req) {
        HttpSession session = req.getSession();
        System.out.println("username:" + req.getParameter("username"));
        System.out.println("password:" + req.getParameter("password"));
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(String username, String password) {
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        return "success";
    }

    /**
     *  String[] hobby 通过数组传参数名形同的多个值
     *  String hobby 也可以 结果用逗号分隔开
     *  形参的参数名和请求参数的名必须保持一致，才能获得请求参数
     *  @RequestParam(value = "user_name") String username
     *          可以使请求参数和形参产生映射关系 就可以使形参用别的名字(别名) 默认有，此注解属性可不写
     *          required=ture 代表此参数必须传,否自会报400错误
     *          required=false 代表有值则赋值，没有则默认null
     *  defaultValue = "hehe" 如果请求参数没传值或传的值为 ''时，使用默认值
     *  --------------------------------------
     *  @RequestHeader("HOST") String host 使用请求头 请求头必须和参数产生映射 必须加 @RequestHeader 注解
     *
     */
    @RequestMapping("/testParam1")
    public String testParam1(@RequestParam(value = "user_name", required = true, defaultValue = "hehe") String username,
                             String password,
                             String hobby,
                             @RequestHeader(value = "sayHaha", required = true, defaultValue = "haha") String host,
                             @CookieValue("JSESSIONID") String JSESSIONID
                            ) {
        // 若请求参数出现多个同名的请求参数，可以再控制器方法的形参位置设置字符串类型或字符串数组类型接收此请求参数
        // 若使用字符串类型的形参，最终结果为请求参数的每一个值知己恩使用逗号进行拼接
        System.out.println(" username:" + username + " password:" + password+" hobby:"+hobby);
        System.out.println("host:"+host);
        System.out.println("JSESSIONID:"+JSESSIONID);
        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user) {
        System.out.println(user);
        return "success";
    }


}
