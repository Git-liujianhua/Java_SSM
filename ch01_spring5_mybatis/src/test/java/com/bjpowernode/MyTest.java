package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.entity.Student;
import com.bjpowernode.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String s : beanDefinitionNames){
            System.out.println("spring容器中的对象"+s+"||"+context.getBean(s).getClass().getName());
        }
    }

    @Test
    public void test02(){
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        Student student = new Student();
        student.setId(1009);
        student.setName("小杰");
        student.setEmail("xiaojie@qq.com");
        student.setAge(24);
        //获取spring中的dao对象
        StudentDao dao = (StudentDao) context.getBean("studentDao");
        int i = dao.insertStudent(student);
        //spring和mybatis整合在一起时候使用，事务是自动提交的，无需执行SqlSession.commit();只要一执行sql语句事务就提交了
        System.out.println(i);
    }

    @Test
    public void test03(){
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        Student student = new Student();
        student.setId(1010);
        student.setName("小刘");
        student.setEmail("xiaoliu@qq.com");
        student.setAge(24);
        StudentService service = (StudentService) context.getBean("studentService");
        int i = service.addStudent(student);
        System.out.println(i);
    }

    @Test
    public void test04(){
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        StudentService service = (StudentService) context.getBean("studentService");
        List<Student> students = service.queryStudent();
        for (Student s : students){
            System.out.println(s);
        }
    }
}
