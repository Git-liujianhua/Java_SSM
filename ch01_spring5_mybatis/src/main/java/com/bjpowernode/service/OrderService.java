package com.bjpowernode.service;

import com.bjpowernode.entity.Student;

import java.util.List;


public interface OrderService {

    int addStudent(Student student);

    List<Student> queryStudent();
}
