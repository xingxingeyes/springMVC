package com.kai.mvc.controller;

import com.kai.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/12/7
 **/
@Controller
public class HttpController {

    /**
     * @RequestBody可以获取请求体，需要在控制器方法设置一个形参，使用@RequestBody进行标识，当 前请求的请求体就会为当前注解所标识的形参赋值
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return "success";
    }

    /**
     * RequestEntity封装请求报文的一种类型，需要在控制器方法的形参中设置该类型的形参，当前请求的
     * 请求报文就会赋值给该形参，可以通过getHeaders()获取请求头信息，通过getBody()获取请求体信息
     */
    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        // 当前requestEntity表示整个请求报文的信息
        System.out.println("请求头：" + requestEntity.getHeaders());
        System.out.println("请求体：" + requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponseBody(HttpServletResponse response) throws IOException {
        response.getWriter().println("hello,response");
    }

    /**
     * @ResponseBody用于标识一个控制器方法，可以将该方法的返回值直接作为响应报文的响应体响应到
     * 浏览器
     */
    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() {
        return "success";
    }

    /**
     * @ResponseBody处理json的步骤：
     *  a>导入jackson的依赖
     *  b>在SpringMVC的核心配置文件中开启mvc的注解驱动，此时在HandlerAdaptor中会自动装配一个消
     *      息转换器：MappingJackson2HttpMessageConverter，可以将响应到浏览器的Java对象转换为Json格
     *      式的字符串
     *  c>在处理器方法上使用@ResponseBody注解进行标识
     *  d>将Java对象直接作为控制器方法的返回值返回，就会自动转换为Json格式的字符串
     *
     */
    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser() {
        // jackson
        return new User(1001,"admin","123",19,"nan");
    }

}
