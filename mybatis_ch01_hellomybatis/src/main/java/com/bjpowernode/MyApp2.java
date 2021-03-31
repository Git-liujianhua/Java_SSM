package com.bjpowernode;


import com.bjpowernode.entity.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class MyApp2 {

    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //【重要】指定执行d的sql语句的标识，sql映射文件中的namespace + "." + 标签的id值
        String sqlId = "com.bjpowermode.dao.StudentDao.selectStudents";
        //【重要】执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        //输出结果
        studentList.forEach(stu -> System.out.println(stu));
        //9、关闭SqlSessiond对象
        sqlSession.close();
    }
}
