package com.bjpowernode.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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


    /**
     * 处理器方法返回ModelAndView，实现转发forward
     * 语法：setViewName("forward:/视图文件的完整路径")
     * forward特点：不和视图解析器一同使用，就当项目中没有视图解析器
     * @return
     */
    @RequestMapping(value = "doForward.do")//如果请求地址中是some.do的都有doSome方法去进行处理
    public ModelAndView doSome(){
        //处理some.do的请求了，相当于service调用处理完成了
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc来做web开发");
        mv.addObject("fun","执行doSome方法");
        //显示转发：不受视图解析器的限制，可以转发到视图解析器以外的视图页面
        // mv.setViewName("forward:/WEB-INF/views/show.jsp");
        mv.setViewName("forward:/hello.jsp");
        return mv;
    }

    /**
     * 处理器方法返回ModelAndView，实现重定向redirect
     * 语法：setViewName("redirect:/视图文件的完整路径")
     * redirect特点：不和视图解析器一同使用，就当项目中没有视图解析器
     *
     * 框架对重定向的操作
     * 1、框架会把Model中的简单类型的数据，转为string使用，作为hello.jsp的get请求参数使用
     *    目的是为了在doRedirect.do和hello.jsp两次请求之间传递数据
     * 2、在hello.jsp页面可以使用参数集合对象${param}获取请求参数值
     *    ${param.myname}
     * 数据放入到request域中
     *
     * 3、重定向不能访问WEB-INF资源
     */

    @RequestMapping(value = "doRedirect.do")
    public ModelAndView doWithRedirect(String name , Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("redirect:/hello.jsp");
        return mv;
    }


}
