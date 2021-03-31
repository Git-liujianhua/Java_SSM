package com.bjpowernode.test;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.entity.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentDaoTest {

    @Test
    public void selectStudents() {
        /**
         * 使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口)
         * getMapper()能获取dao接口对于的实现类对象
         */
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        System.out.println("动态代理" + dao);
        //调用dao方法，执行数据库操作
        List<Student> students = dao.selectStudents();
        students.forEach(stu -> System.out.println(stu));
    }

    @Test
    public void insertStudent() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1008);
        student.setName("曹操");
        student.setEmail("caocao@qq.com");
        student.setAge(25);
        int i = dao.insertStudent(student);
        sqlSession.commit();
        System.out.println("插入数据：" + i);
    }
}