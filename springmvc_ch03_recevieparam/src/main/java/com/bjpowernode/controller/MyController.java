package com.bjpowernode.controller;

import com.bjpowernode.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
     * 逐个接收请求参数
     *          要求：处理起（控制器）方法的形参名和请求中的参数名必须一致
     *               同名的请求参数赋值给同名的形参
     * 框架接收请求的参数
     *      1、使用request对象接收请求参数（所有的参数原始类型都是字符串）
     *      String strName = request.getParameter("name");
     *      String strAge = request.getParameter("age");
     *      2、SpringMVC框架通过中央调度器DispatcherServlet 调用MyController中的doSome()方法
     *      调用方法时候，按名称对应，把接收的参数赋值给形参（和参数的位置无关，传过去的参数可以和接收的形参数量不一致）
     *      doSome(strName,Integer.valueOf(strAge));
     *      框架会提供类型转换的功能，能把String，转换为int，long，float，double等类型
     *
     *      状态码：400：状态码是客户端错误，表示提交请求参数过程中，发生了错误
     *      表示我们在请求中把数据提交给服务器的Controller，在过程中发生了错误
     *      不会抛出异常，spring写在了自己的日志中了
     *
     *      如果参数不能正常接收，那么Controller中的doSome方法就不会执行
     *
     *      POST请求中文会出现乱码，GET请求没有
     *      在过滤器中来设置字符编码，在过滤器中设置编码的方式
     * @return
     */
    @RequestMapping(value = "/receiveproperty.do")
    public ModelAndView doSome(String name,Integer age ,String email, Integer i){
        System.out.println(name + ":" + age + ":" + email + ":"+ i);
        //可以在方法中直接使用name，age的值了
        //处理some.do的请求了，相当于service调用处理完成了
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName",name);
        mv.addObject("myAge",age);
        //show是视图文件的逻辑名称（文件名称）
        mv.setViewName("show");
        return mv;
    }

    /**
     * 请求中的参数名和处理器的方法的形参名不一样
     * @RequestParam(): 解决请求中参数名形参名不一样的问题
     *                  属性：1、value  请求中的参数名称
     *                       2、required  是一个boolean类型的，默认是true（用在逐个接收参数的方案中的）
     *                          true：表示请求中必须包含此参数
     *                  位置：在处理器方法的形参定义的前面
     *         状态码：400：
     *         HTTP Status 400 – Bad Request
     *         Type Status Report
     *
     *         Message Required String parameter 'rname' is not present
     *
     *         Description The server cannot or will not process the request due to something that is perceived to be a client error (e.g., malformed request syntax, invalid request message framing, or deceptive request routing).
     *         状态码是客户端错误，表示提交请求参数过程中，发生了错误
     *         表示我们在请求中把数据提交给服务器的Controller，在过程中发生了错误
     *         不会抛出异常，spring写在了自己的日志中了
     *
     *
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/receiveparam.do")
    public ModelAndView receiveparam(@RequestParam(value = "rname",required = false) String name,@RequestParam(value = "rage",required = false) Integer age){
        System.out.println(name + ":" + age);
        //可以在方法中直接使用name，age的值了
        //处理some.do的请求了，相当于service调用处理完成了
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName",name);
        mv.addObject("myAge",age);
        //show是视图文件的逻辑名称（文件名称）
        mv.setViewName("show");
        return mv;
    }

    /**
     * 处理器方法形参是java对象，这个对象的属性名和请求中参数名是一样的
     * 框架会自动创建形参的Java对象，给属性赋值。请求中的参数是name，框架会调用setName()，类似于Spring中的set注入，看到的是name，springmvc执行的是setName
     * 形参中的Java对象有框架进行创建和属性赋值
     *      1、省去了大段的set方法调用不需要开发人员再去写了
     *      2、对象已经在形参中框架为我们创建好了，可以在方法中直接使用Java对象中的get方法和toString方法等
     *      3、也可以把这个对象传给Service、Dao
     *      4、特别在接收多个参数时候，使用对象去接收参数最为方便
     *      5、只要定义一个对象，只要属性名和请求参数名一样框架就能接收，并给属性赋值
     *      6、而且形参中可以有多个对象，也可以和普通类型形参去搭配使用都没问题
     *      （根据形参中对象的创建按照同名的原则把请求中的同名的参数赋值给同名的属性，请求中普通类型的参数也会直接赋值）
     *      互不干扰形参中可以有多个对象和多个普通类型的形参共存，框架都会创建他们的实例并给属性赋值
     * 这种方式在实际的开发应用中是最多的一种方式
     */
    @RequestMapping(value = "/receiveobject.do")
    public ModelAndView receiveobject(Student myStudent){
        System.out.println(myStudent.getName() + ":" + myStudent.getAge());
        //可以在方法中直接使用name，age的值了
        //处理some.do的请求了，相当于service调用处理完成了
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName",myStudent.getName());
        mv.addObject("myAge",myStudent.getAge());
        mv.addObject("myStudent",myStudent.toString());
        //show是视图文件的逻辑名称（文件名称）
        mv.setViewName("show");
        return mv;
    }
}
