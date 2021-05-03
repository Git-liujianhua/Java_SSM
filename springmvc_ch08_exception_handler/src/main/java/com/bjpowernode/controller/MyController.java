package com.bjpowernode.controller;

import com.bjpowernode.exception.AgeException;
import com.bjpowernode.exception.MyUserException;
import com.bjpowernode.exception.NameException;
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



    @RequestMapping(value = "doSome.do")//如果请求地址中是some.do的都有doSome方法去进行处理
    public ModelAndView doSome(String name,Integer age) throws MyUserException {
        //处理some.do的请求了，相当于service调用处理完成了
        ModelAndView mv = new ModelAndView();
        if (!"zs".equals(name)){
            throw new NameException("姓名不正确！！！");
        }
        if (age == null || age >80){
            throw new AgeException("年龄太大！！！");
        }
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //显示转发：不受视图解析器的限制，可以转发到视图解析器以外的视图页面
        // mv.setViewName("forward:/WEB-INF/views/show.jsp");
        mv.setViewName("show");
        return mv;
    }
    //TODO：水水水水



}
