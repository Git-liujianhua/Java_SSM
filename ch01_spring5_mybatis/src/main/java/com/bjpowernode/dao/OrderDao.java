package com.bjpowernode.dao;

import com.bjpowernode.entity.Student;

import java.util.List;

public interface OrderDao {

    int insertStudent(Student student);

    List<Student> selectStudents();
}
