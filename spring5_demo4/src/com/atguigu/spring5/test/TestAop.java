package com.atguigu.spring5.test;

import com.atguigu.spring5.aopanno.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }
}

class test {
    public static String output = "";

    public static void foo(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
            output += "1";
            System.out.println(output);
        } catch (Exception e) {
            output += "2";
            System.out.println(output);
            return;
        } finally {
            output += "3";
            System.out.println(output);
        }
        output += "4";
        System.out.println(output);
    }

    public static void main(String[] args) {
        foo(0);

        foo(1);


    }
}