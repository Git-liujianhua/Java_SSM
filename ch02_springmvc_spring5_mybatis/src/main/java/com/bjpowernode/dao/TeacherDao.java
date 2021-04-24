package com.bjpowernode.dao;

import com.bjpowernode.entity.Teacher;

import java.util.List;

public interface TeacherDao {

    int insertTeacher(Teacher teacher);

    List<Teacher> selectTeachers();
}
