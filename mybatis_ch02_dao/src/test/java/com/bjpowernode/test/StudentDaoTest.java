package com.bjpowernode.test;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.dao.impl.StudentDaoImpl;
import com.bjpowernode.entity.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoTest {

    //com.bjpowernode.dao.StudentDao
    private StudentDao studentDao = new StudentDaoImpl();

    @Test
    public void selectStudents() {
        /**
         *  List<Student> students = studentDao.selectStudents();
         *  1、dao对象，类型是StudentDao，全限定名称是com.bjpowernode.dao.StudentDao
         *      全限定名称 和 namespace 是一样的
         *  2、方法名称：selectStudents，这个方法就是mapper文件中id的值selectStudents
         *
         *  3、通过dao中方法的返回值也可以确定MyBatis要调用的SqlSession的方法
         *      如果返回值是List，调用的是SqlSession.selectStudentList()方法
         *      如果返回值是int，或是非List的，看mapper文件中的标签是<insert>,<update>就会调用SqlSession的insert，update等方法
         */
        List<Student> students = studentDao.selectStudents();
        students.forEach(stu -> System.out.println(stu));
    }

    @Test
    public void insertStudent() {
        Student student = new Student();
        student.setId(1006);
        student.setName("关二爷");
        student.setEmail("guanerye@qq.com");
        student.setAge(20);
        studentDao.insertStudent(student);
    }
}