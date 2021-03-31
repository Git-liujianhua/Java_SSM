package com.bjpowernode.dao;


import com.bjpowernode.entity.Student;

import java.util.List;

public interface StudentDao {


    /**
     * 动态sql，使用Java对象作为参数
     */
    public List<Student> selectStudentIf(Student student);

    /**
     * where使用
     */
    public List<Student> selectStudentWhere(Student student);

    /**
     * foreach使用的用法1
     */
    public List<Student> selectStudentForEachOne(List<Integer> idlist);

    /**
     * foreach使用的用法2 循环对象
     */
    public List<Student> selectStudentForEachTwo(List<Student> stulist);
}
