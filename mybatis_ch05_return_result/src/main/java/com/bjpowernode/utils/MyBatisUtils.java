package com.bjpowernode.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {

    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        String config = "mybatis.xml";  //需要和你的项目中的文件名一样
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(config);
            //创建SqlSessionFactory对象，使用SqlSessionFactoryBuilder对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取SqlSession方法
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        if (sqlSessionFactory != null){
             sqlSession = sqlSessionFactory.openSession();//非自动提交事务
        }
        return sqlSession;
    }
}
