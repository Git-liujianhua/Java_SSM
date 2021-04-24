package com.bjpowernode.controller;

import com.bjpowernode.vo.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * @RequestMapping:
 *  value：所有请求地址的公共部分，叫做模块名称
 *  位置：放在类的上面
 */
@Controller
public class MyController {


    /**
     * 使用完整视图路径的话不能使用视图解析器，使用逻辑视图名称必须使用视图解析器
     * 处理器方法返回String----表示逻辑视图名称，需要配置视图解析器
     * @return
     */
    @RequestMapping(value = "/returnString-view.do")
    public String doReturnView(HttpServletRequest request,String name , String age){
        System.out.println("doReturnView" + name + ":" + age);

        request.setAttribute("myName",name);
        request.setAttribute("myAge",age);
        //show：逻辑视图名称，项目中配置了视图解析器
        //框架对视图执行的是一个forward转发操作
        return "show";
    }

    /**
     * 处理器方法返回String，表示完整视图路径，此时不能配置视图解析器
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/returnString-view2.do")
    public String doReturnView2(HttpServletRequest request,String name,Integer age){
        System.out.println("=====doReturnView2======" + name + ":" + age);
        request.setAttribute("myName",name);
        request.setAttribute("myAge",age);
        //完整视图路径，项目中不能配置了视图解析器
        //框架对视图执行的是一个forward转发操作
        //如果配置了视图解析器后会导致的情况
        // HTTP Status 404 – Not Found
        // Type Status Report
        // Message /springmvc_ch04_return/WEB-INF/views//WEB-INF/views/show.jsp.jsp
        return "/WEB-INF/views/show.jsp";
    }

    /**
     * 处理器方法返回Void，响应ajax请求
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/returnVoid-ajax.do")
    public void doReturnVoidAjax(HttpServletResponse response,String name,Integer age) throws IOException {
        System.out.println("=====doReturnView2======" + name + ":" + age);
        //c处理ajax，使用json做数据的格式
        //相当于service调用完成了，使用Student表示处理结果
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        String json = "";
        //把结果的对象转为json格式的数据
        if (student != null){
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(student);
        }
        //输出数据，响应ajax请求
        //设置输出格式json
        //告诉浏览器响应的是json格式的数据
        response.setContentType("application/json;charset=utf-8");
        //根据getWriter()获取一个PrintWriter对象
        PrintWriter writer = response.getWriter();
        //输出数据
        writer.print(json);
        //刷新缓存
        writer.flush();
        //关闭PrintWriter
        writer.close();
    }

    /**
     * 处理器方法返回一个Student，通过框架转为Json，响应ajax请求
     * @ResponseBody：
     *      作用：把处理器方法返回对象转为json后，通过HttpServletResponse输出给浏览器
     *      位置：方法的定义上面。和其他注解没有顺序关系
     * 返回对象框架的处理过程：
     * （1）框架会把返回Student类型，调用框架中的ArrayList<HttpMessageConverter>中每个类的canWrite()方法；检查哪个HttpMessageConverter接口的实现类能处理Student类型的数据--MappingJackson2HttpMessageConverter
     * （2）框架会调用实现类的Writer()，MappingJackson2HttpMessageConverter的Writer()方法，把李四同学的student对象转为json，调用Jackson的ObjectMapper实现转为json
     * contentType : application/json;charset=utf-8
     * （3）框架会调用@ResponseBody把MappingJackson2HttpMessageConverter的处理结果数据输出到浏览器中，ajax请求处理完成
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "returnStudentJson.do")
    @ResponseBody
    public Student doStudentJsonObject(String name,String age){
        //调用service，获取请求结果数据，Student对象表示结果数据
        Student student = new Student();
        student.setName("李四");
        student.setAge(20);
        return student; //会被框架转为json
    }

    /**
     * 处理器方法返回List<Student>
     *     List<Student>集合最终会被转成一个数组
     *     List集合既能保存多个对象，同时也能按照传入顺序来排列对象，返回List常用最终的结果是返回一个json的数组（jsonArray）
     * 也可以用Map返回多个值：但是不建议用map：
     *         原因：不方便，map使用需要又key的支持需要通过key名字才能找到value中的对象，而且常用的map也不能排序
     *  返回对象框架的处理过程：
     * （1）框架会把返回List<Student>类型，调用框架中的ArrayList<HttpMessageConverter>中每个类的canWrite()方法；检查哪个HttpMessageConverter接口的实现类能处理Student类型的数据--MappingJackson2HttpMessageConverter
     * （2）框架会调用实现类的Writer()，MappingJackson2HttpMessageConverter的Writer()方法，把李四同学的student对象转为json，调用Jackson的ObjectMapper实现转为json数组（jsonArray）
     * contentType : application/json;charset=utf-8
     * （3）框架会调用@ResponseBody把MappingJackson2HttpMessageConverter的处理结果数据输出到浏览器中，ajax请求处理完成
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "returnStudentJsonArray.do")
    @ResponseBody
    public List<Student> doStudentJsonObjectArray(String name, String age){
        List<Student> list = new ArrayList<>();
        //调用service，获取请求结果数据，Student对象表示结果数据
        Student student = new Student();
        student.setName("李四");
        student.setAge(20);
        list.add(student);

        student = new Student();
        student.setName("张三");
        student.setAge(29);
        list.add(student);
        return list;
    }

    /**
     * 处理器方法返回的是String ， String 表示的是数据，不是视图
     * 区分返回值String 是数据还是视图，看有没有@RequestBody注解
     * 如果有@RequestBody注解，返回String就是数据，反之就是视图。
     *
     * 默认使用“text/plain;charset=ISO-8859-1”作为contentType，导致中文有乱码
     * 解决方案：给RequestMapping增加一个属性produces，使用这个属性指定新的contentType
        返回对象框架的处理过程：
     * （1）框架会把返回String类型，调用框架中的ArrayList<HttpMessageConverter>中每个类的canWrite()方法；检查哪个HttpMessageConverter接口的实现类能处理Student类型的数据--StringHttpMessageConverter
     * （2）框架会调用实现类的Writer()，StringHttpMessageConverter的Writer()方法
     *      把字符按照指定的编码处理：默认是（text/plain;charset=ISO-8859-1），再@requestMapping注解中使用produces属性指定编码（produces = "text/plain;charset=UTF-8"）
     * （3）框架会调用@ResponseBody把MappingJackson2HttpMessageConverter的处理结果数据输出到浏览器中，ajax请求处理完成
     *
     * 实际开发中：返回String数据、List集合、对象用的较多
     * 返回值Object代表的数据，处理的ajax请求
     */
    @RequestMapping(value = "returnStringData.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String doStringData(String name,Integer age){
        return "hello springmvc 字符串 数据";
    }


}
