package com.bjpowernode.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器类：拦截用户的请求
 */
public class MyHandlerInterceptor2 implements HandlerInterceptor {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //计算的业务逻辑，根据计算结果，返回true和false
        System.out.println("2==========1、拦截器的MyHandlerInterceptor的preHandle()========");
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("2==========2、拦截器的MyHandlerInterceptor的postHandle()========");
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("2==========3、拦截器的MyHandlerInterceptor的afterCompletion()========");
    }
}
