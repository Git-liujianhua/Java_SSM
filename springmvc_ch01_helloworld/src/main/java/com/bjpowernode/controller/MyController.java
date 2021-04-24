package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller:创建处理器对象，对象放在springmvc容器中
 * 位置：在类的上面
 * 和Spring中讲的@Service，@Component一样都是创建对象的
 *
 * 能处理请求的都是控制器（处理器）：MyController能处理请求，也叫做后端控制器（back controller ）
 */
@Controller
public class MyController {

    /**
     * 处理用户提交的请求，springmvc中使用方法来处理的
     * 方法是自定义的，可以有多种返回值，多种参数，方法名称自定义
     * @return
     */

    /**
     * 准备使用doSome方法处理some.do请求
     * @RequestMapping：请求映射，作用是把一个请求地址和一个方法绑定在一起。
     *                  一个请求指定一个方法处理。
     *          属性：1、value是一个String，表示请求的uri地址的（some.do）。
     *                  value的值必须是唯一的，不能重复，在使用时，推荐地址以“/”开头
     *                  value是一个字符串数组，里边可以放多个值
     *          位置：1、在方法的上面使用，常用的一种方式
     *               2、在类的上面使用
     * 说明：使用@RequestMapping修饰的方法叫做处理起方法或者控制器方法
     *      使用@RequestMapping修饰的方法可以处理请求的，类似于Servlet中的doGet、doPost
     *
     * 返回值：ModelAndView  表示本次请求的处理结果的数据和视图
     *      model：数据，请求处理完成后，要显示给用户的数据
     *      View：视图，比如jsp等等
     *      first ，second
     */
    @RequestMapping(value = {"some.do","first.do"})//如果请求地址中是some.do的都有doSome方法去进行处理
    public ModelAndView doSome(){  //doGet ----调用Service请求处理
        //处理some.do的请求了，相当于service调用处理完成了
        ModelAndView mv = new ModelAndView();
        //添加数据，框架在请求的最后把数据放入到了request域中
        //相当于是：request.setAttribute("fun","执行doSome方法");
        mv.addObject("msg","欢迎使用springmvc来做web开发");
        mv.addObject("fun","执行doSome方法");

        //指定视图：指定视图的完整路径
        //框架对视图执行的forward操作，request.getRequestDispatcher("/show.jsp").forward(.......);
        // mv.setViewName("/WEB-INF/views/show.jsp");
        // mv.setViewName("/WEB-INF/views/show.jsp");
        //当配置了视图解析器后，可以使用逻辑名称（文件名），指定视图
        //框架会使用视图解析器的前缀 + 逻辑名称（文件名） + 后缀 , 这里就是字符串连接的操作
        ///WEB-INF/views/ + show + .jsp
        mv.setViewName("show");
        //返回mv
        //数据和视图都是放在了mv里边去了，mv返回值会在后期做setAttribute和forward处理
        //不需要再和以前去使用servlet时候去自己写：//相当于是：request.setAttribute("fun","执行doSome方法");、
        // 框架对视图执行的forward操作，request.getRequestDispatcher("/show.jsp").forward(.......);等这些处理代码了
        return mv;
    }

    @RequestMapping(value = {"other.do","second.do"})
    public ModelAndView doOther(){

        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","======欢迎使用springmvc来做web开发======");
        mv.addObject("fun","======执行doOther方法======");

        mv.setViewName("other");

        return mv;
    }

}
