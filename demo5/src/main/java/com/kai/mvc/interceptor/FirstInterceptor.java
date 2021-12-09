package com.kai.mvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 拦截器
 * @author: kai.lv
 * @date: 2021/12/8
 **/
@Component
public class FirstInterceptor implements HandlerInterceptor {

    /** 在控制器方法执行之前执行 */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("firstInterceptor-->preHandle");
        // 返回值表示是否放行 true 放行， false 拦截
        return true;
    }

    /** 在控制器方法执行之后执行 */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("firstInterceptor-->postHandle");
    }

    /** 在视图渲染之后执行 */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("firstInterceptor-->afterHandle");
    }
}
