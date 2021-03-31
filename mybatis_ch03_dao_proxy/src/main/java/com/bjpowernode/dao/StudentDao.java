package com.bjpowernode.dao;

import com.bjpowernode.entity.Student;

import java.util.List;

public interface StudentDao {

    //查询
    public List<Student> selectStudents();

    //添加
    public int insertStudent(Student student);
}
