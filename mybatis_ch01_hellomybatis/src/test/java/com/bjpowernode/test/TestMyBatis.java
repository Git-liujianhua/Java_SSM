package com.bjpowernode.test;

import com.bjpowernode.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMyBatis {

    @Test
    public void insertStudentTest() throws IOException {
        //访问mybatis读取student数据
        //1、定义mybatis主配置文件d的名称，从类路径的根开始（target/classes）
        String config = "mybatis.xml";
        //2、读取config表示的文件
        InputStream resourceAsStream = Resources.getResourceAsStream(config);
        //3、创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4、创建SqlSessionFactory对象
        SqlSessionFactory build = builder.build(resourceAsStream);
        //5、【重要】获取SqlSession对象，从SqlSessionFactory中获取sqlSession
        SqlSession sqlSession = build.openSession();
        //6、【重要】指定执行d的sql语句的标识，sql映射文件中的namespace + "." + 标签的id值
        String insterStudent = "com.bjpowermode.dao.StudentDao.insertStudent";
        Student student = new Student();
        student.setId(1005);
        student.setName("刘备");
        student.setEmail("liubei@qq.com");
        student.setAge(30);
        //7、【重要】执行sql语句，通过sqlId找到语句
        int insert = sqlSession.insert(insterStudent,student);
        //mybatis默认不是自动提交事务的，所以再insert，update，delete后要手动提交事务
        sqlSession.commit();
        //输出
        System.out.println(insert);
        //关闭
        sqlSession.close();
    }
}
