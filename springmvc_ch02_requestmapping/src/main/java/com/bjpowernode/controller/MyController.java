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
@RequestMapping("/user")
public class MyController {

    /**
     * @RequestMapping：请求映射
     *            属性：method，表示请求的方式，他的值RequestMethod类枚举值
     *                 例如：表示get请求的方式：RequestMethod.GET
     *                      表示post请求的方式：RequestMethod.POST
     *
     * 如果请求的方式不是指定的请求方式Post或是get请求会报405错误
     * HTTP Status 405 – Method Not Allowed
     * Type Status Report
     *
     * Message Request method 'GET' not supported
     *
     * Description The method received in the request-line is known by the origin server but not supported by the target resource.
     * @return
     */
    //地址要和前端的请求地址一致
    //指定some.do使用get的请求方式
    @RequestMapping(value = "/some.do",method = RequestMethod.GET)//如果请求地址中是some.do的都有doSome方法去进行处理
    public ModelAndView doSome(){  //doGet ----调用Service请求处理
        //处理some.do的请求了，相当于service调用处理完成了
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc来做web开发");
        mv.addObject("fun","执行doSome方法");
        mv.setViewName("show");
        return mv;
    }

    //指定other.do使用post请求方式
    @RequestMapping(value = {"/other.do","/second.do"},method = RequestMethod.POST)
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","======欢迎使用springmvc来做web开发======");
        mv.addObject("fun","======执行doOther方法======");
        mv.setViewName("other");
        return mv;
    }

    //不指定请求方式，没有限制
    @RequestMapping(value = "/first.do")
    public ModelAndView doFirst(HttpServletRequest request , HttpServletResponse response , HttpSession httpSession){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","======欢迎使用springmvc来做web开发======");
        mv.addObject("fun","======执行doFirst方法====== " + request.getParameter("name"));
        mv.setViewName("other");
        return mv;
    }

}
