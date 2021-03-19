package com.atguigu.spring5.test;


import com.atguigu.spring5.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

// @ExtendWith(SpringExtension.class)              //单元测试框架
// @ContextConfiguration("classpath:bean1.xml")    //加载配置文件

@SpringJUnitConfig(locations = "classpath:bean1.xml")  //使用一个复合注解替代上面两个注解完成整合
public class JTest5 {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.accountMoney();
    }
}
