package com.atguigu.spring5.test;

import com.atguigu.spring5.config.TxConfig;
import com.atguigu.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

public class Tests {

    @Test
    public void testAccount() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();

    }

    @Test
    public void testAccount1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();

    }

    //使用配置文件使用的方法
    // ClassPathXmlApplicationContext("bean2.xml");
    //使用配置类使用的方法
    // AnnotationConfigApplicationContext(TxConfig.class);

    @Test
    public void testAccount2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();

    }

    //函数式风格创建对象，交给Spring进行管理
    @Test
    public void testGenericApplicationContext() {
        //1 创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        //2 调用context的方法注册对象
        context.refresh();
        //2 创建类型的class，使用Lambda表达式把对象直接new出来完成注册
        context.registerBean("user", User.class, () -> new User());
        //3 获取spring注册的对象
        //两种写法：
        //第一种：User user = (User) context.getBean("com.atguigu.spring5.test.User");在getBean中写类的全路径
        //第二种：context.registerBean("user",User.class ,() -> new User());注册的时候指定对象的名字
        // User user = (User) context.getBean("com.atguigu.spring5.test.User");
        User user = (User) context.getBean("user");
        System.out.println(user);

    }
}
