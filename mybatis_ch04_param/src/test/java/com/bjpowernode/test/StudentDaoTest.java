package com.bjpowernode.test;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.entity.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoTest {

    @Test
    public void selectStudentById() {
        /**
         * 使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口)
         * getMapper()能获取dao接口对于的实现类对象
         */
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //调用dao方法，执行数据库操作
        Student student = dao.selectStudentById(1004);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void selectMultiParam(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiParam("关二爷", 20);
        for (Student stu : students){
            System.out.println("学生：" + stu);
        }
        sqlSession.close();
    }
    @Test
    public void selectMultiObject(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiObject(new QueryParam("关二爷", 20));
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();
    }

    @Test
    public void selectMultiStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        // List<Student> students = dao.selectMultiObject(new QueryParam("关二爷", 20));
        // students.forEach(stu -> System.out.println(stu));
        Student student = new Student();
        student.setName("关二爷");
        student.setAge(20);
        List<Student> students = dao.selectMultiStudent(student);
        for (Student stu : students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void selectMultiPosition(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiPosition("关二爷", 20);
        for (Student stu : students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    //使用map传参
    @Test
    public void selectMultiByMap(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<String,Object> map = new HashMap<>();
        map.put("myname","关二爷");
        map.put("myage",20);
        List<Student> students = dao.selectMultiByMap(map);
        for (Student stu : students){
            System.out.println(stu);
        }
        sqlSession.close();
    }


}