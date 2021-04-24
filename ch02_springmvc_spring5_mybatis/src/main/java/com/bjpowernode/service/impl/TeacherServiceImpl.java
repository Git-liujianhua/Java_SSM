package com.bjpowernode.service.impl;

import com.bjpowernode.dao.TeacherDao;
import com.bjpowernode.entity.Teacher;
import com.bjpowernode.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    //引用类型的自动注入@Autowired，@Resource
    @Resource
    private TeacherDao teacherDao;

    @Override
    public int addTeacher(Teacher teacher) {
        int nums = teacherDao.insertTeacher(teacher);
        return nums;
    }

    @Override
    public List<Teacher> findTeachers() {
        List<Teacher> teachers = teacherDao.selectTeachers();
        return teachers;
    }
}
