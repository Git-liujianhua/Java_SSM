package com.atguigu.spring5.test;

import com.atguigu.spring5.Book;
import com.atguigu.spring5.Orders;
import com.atguigu.spring5.User;
import com.atguigu.spring5.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.beans.beancontext.BeanContext;

public class TestSpring5 {

    @Test
    public void test() {

        //1  加载Spring配置文件
        // ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BeanFactory context = new FileSystemXmlApplicationContext("D:\\file\\IdeaProjects\\Java_SSM\\spring_demo\\src\\bean1.xml");
        //2  获取配置创建对象最后调用方法
        User user = context.getBean("user", User.class);

        System.out.println(user);

        user.add();
    }

    @Test
    public void testBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book", Book.class);

        System.out.println(book);

        book.addBook();
    }

    @Test
    public void testOrders() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        Orders orders = context.getBean("orders", Orders.class);

        System.out.println(orders);

        orders.addOrders();
    }


}
