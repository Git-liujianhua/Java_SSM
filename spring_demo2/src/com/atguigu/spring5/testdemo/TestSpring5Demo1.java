package com.atguigu.spring5.testdemo;

import com.atguigu.spring5.autowire.Emp;
import com.atguigu.spring5.bean.Order;
import com.atguigu.spring5.collectiontype.Book;
import com.atguigu.spring5.collectiontype.Course;
import com.atguigu.spring5.collectiontype.Stu;
import com.atguigu.spring5.factorybean.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5Demo1 {

    @Test
    public void testCollection() {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        Stu stu = context.getBean("stu", Stu.class);

        System.out.println(stu);
        stu.test();


    }

    @Test
    public void testBook() {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        Book book = context.getBean("book", Book.class);

        System.out.println(book);
        book.test();
    }

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }

    @Test
    public void testBean() {
        // 4）Bean可以使用了（对象获取到了）
        // ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Order order = context.getBean("order", Order.class);
        System.out.println("第五步 获取创建bean对象对象");
        System.out.println(order);
        //手动让Bean实例销毁
        // ((ClassPathXmlApplicationContext)context).close();
        context.close();
    }

    @Test
    public void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        Emp emp = context.getBean("emp", Emp.class);
        emp.test();
        System.out.println(emp);
    }
}
