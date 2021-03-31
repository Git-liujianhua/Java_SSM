package com.bjpowernode.test;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.entity.MyStudent;
import com.bjpowernode.entity.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.QueryParam;
import com.bjpowernode.vo.ViewStudent;
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
    public void selectStudentReturnViewStudentTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        ViewStudent viewStudent = dao.selectStudentReturnViewStudent(1004);
        System.out.println(viewStudent);
        sqlSession.close();
    }

    @Test
    public void selectCountTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int i = dao.selectCount();
        System.out.println(i);
        sqlSession.close();
    }

    //返回map
    @Test
    public void selectMapByIdTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<Object, Object> objectObjectMap = dao.selectMapById(1004);
        System.out.println(objectObjectMap);
        sqlSession.close();
    }

    //返回自定义的resultMap
    @Test
    public void selectResultMapAllStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectAllStudents();
        for (Student stu : students){
            System.out.println("学生："+ stu);
        }
        sqlSession.close();
    }

    //返回自定义的resultMap:数据库列名和java对象属性名不一致的情况
    @Test
    public void selectResultMapAllMyStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> myStudents = dao.selectAllMyStudents();
        for (MyStudent stu : myStudents){
            System.out.println("学生："+ stu);
        }
        sqlSession.close();
    }

    //返回自定义的resultMap:数据库列名和java对象属性名不一致的情况
    @Test
    public void selectDiffColPropertyTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> myStudents = dao.selectDiffColProperty();
        for (MyStudent stu : myStudents){
            System.out.println("############3学生："+ stu);
        }
        sqlSession.close();
    }

    //第一种like，java代码中指定like的内容
    @Test
    public void selectLikeOne(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectLikeOne("%关%");
        for (Student stu : students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    //第一种like，mapper文件中指定like的内容
    @Test
    public void selectLikeTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectLikeTwo("关");
        for (Student stu : students){
            System.out.println("111111111111=" + stu);
        }
        sqlSession.close();
    }

}