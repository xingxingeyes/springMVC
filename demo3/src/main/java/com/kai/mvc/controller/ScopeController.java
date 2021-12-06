package com.kai.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @description: 向request域中设置值的几种方式
 * @author: kai.lv
 * @date: 2021/12/6
 **/
@Controller
public class ScopeController {

    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest req) {
        req.setAttribute("testRequestScope", "helloServletAPI");
        return "success";
    }

    // request域共享数据 建议 ModelAndView 方式
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView mav = new ModelAndView();
        // 处理模型数据，即向请求域request共享数据
        mav.addObject("testRequestScope", "hello,ModelAndView");
        // 设置视图名称
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "hello,model");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("testRequestScope", "hello,map");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testRequestScope", "hello,modelMap");
        return "success";
    }

    // session域共享数据建议用ServletAPI方式
    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "hello,session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope", "hello,application");
        return "success";
    }



}
