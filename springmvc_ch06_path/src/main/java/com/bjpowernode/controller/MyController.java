package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @RequestMapping:
 *  value：所有请求地址的公共部分，叫做模块名称
 *  位置：放在类的上面
 */
@Controller
public class MyController {


    @RequestMapping(value = "/user/some.do",method = RequestMethod.POST)//如果请求地址中是some.do的都有doSome方法去进行处理
    public ModelAndView doSome(){  //doGet ----调用Service请求处理
        //处理some.do的请求了，相当于service调用处理完成了
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc来做web开发");
        mv.addObject("fun","执行doSome方法");
        mv.setViewName("show");
        return mv;
    }


}
