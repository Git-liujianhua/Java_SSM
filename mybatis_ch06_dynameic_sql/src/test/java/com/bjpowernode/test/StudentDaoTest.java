package com.bjpowernode.test;


import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.entity.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoTest {

    //<if test = "">标签
    @Test
    public void selectStudentIfTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("李四");
        student.setAge(18);
        List<Student> students = dao.selectStudentIf(student);
        for (Student stu : students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    //<where><if><if><where>
    @Test
    public void selectStudentWhereTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        // student.setName("李四");
        student.setAge(20);
        List<Student> students = dao.selectStudentWhere(student);
        for (Student stu : students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void selectFor(){
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);

        // String sql = "select * from t_student id in (1001,1002,1003)";
        String sql = "select * from t_student id in";
        StringBuilder builder = new StringBuilder();
        int init = 0;
        int len = list.size();

        //添加开始的(
        builder.append("(");
        for (Integer i : list){
            builder.append(i).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        //添加结束的 ) 循环结尾
        builder.append(")");

        sql = sql + builder.toString();
        System.out.println(sql);
    }

    @Test
    public void selectStudentForEachTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> students = dao.selectStudentForEachOne(list);
        for (Student stu : students){
            System.out.println(stu);
        }
    }

    @Test
    public void selectStudentForEachTestTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        student.setId(1001);
        studentList.add(student);
        student = new Student();
        student.setId(1002);
        studentList.add(student);
        List<Student> students = dao.selectStudentForEachTwo(studentList);
        for (Student stu : students){
            System.out.println(stu);
        }
    }

    @Test
    public void selectStudentAllPageHelperTest(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //加入PageHelper的方法，分页
        //pageNum：第几页，从1开始
        //pageSize：一页中有多少行数据
        PageHelper.startPage(3,3);
        List<Student> students = dao.selectStudentAllPageHelper();
        for (Student stu : students){
            System.out.println(stu);
        }
    }

}