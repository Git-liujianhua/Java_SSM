package com.bjpowernode.controller;

import com.bjpowernode.entity.Teacher;
import com.bjpowernode.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("teacher")
public class TeacherController {

    //引用类型的自动注入@Autowired，@Resource
    @Resource
    private TeacherService teacherService;

    @RequestMapping("addTeacher.do")
    public ModelAndView addTeacher(Teacher teacher){
        ModelAndView modelAndView = new ModelAndView();
        String tips = "注册失败";
        //调用service处理teacher
        int nums = teacherService.addTeacher(teacher);
        if (nums > 0){
            //注册成功
            tips = "教师【" + teacher.getName() + "】注册成功";
        }
        //添加数据
        modelAndView.addObject("tips" , tips);
        //指定结果页面
        modelAndView.setViewName("result");

        return modelAndView;
    }

    //处理查询
    @RequestMapping("queryTeacher.do")
    @ResponseBody
    public List<Teacher> queryTeacher(){
        //参数检查，简单的数据处理
        List<Teacher> teachers = teacherService.findTeachers();
        return teachers;
    }

}
