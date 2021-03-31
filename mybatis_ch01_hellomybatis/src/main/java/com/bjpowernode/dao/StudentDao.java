package com.bjpowernode.dao;

import com.bjpowernode.entity.Student;

import java.util.List;

//接口操作student表
public interface StudentDao {

    //查询student表种的所有数据
    public List<Student> selectStudents();

    // 插入方法
    //参数：student，表示要插入到数据库的数据
    //返回值：int，表示insert操作后的影响数据库的行数
    public int insertStudent(Student student);
}
