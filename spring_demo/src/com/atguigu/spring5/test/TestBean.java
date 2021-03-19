package com.atguigu.spring5.test;

import com.atguigu.spring5.bean.Emp;
import com.atguigu.spring5.service.UserService;
import com.atguigu.spring5.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;

public class TestBean {

    @Test
    public void userServiceTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserServiceImpl userServiceImpl = context.getBean("userServiceImpl", UserServiceImpl.class);
        System.out.println(userServiceImpl);
        userServiceImpl.add();

    }

    @Test
    public void EmpTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
        emp.add();
    }


    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }

    @Test
    public void Test() {
        int i = 2147483647;
        int y = (2147483641 * 10) / 10;
        int x = (2147483647 * 10) / 10;
        int z = (746384741 * 10) / 10;

        System.out.println(i);
        System.out.println(y);
        System.out.println(x);
        System.out.println(reverse(2147483647));
        System.out.println(z);
    }
}
