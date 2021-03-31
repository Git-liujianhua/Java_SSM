package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 在注解里面value的属性值可以省略不写，默认值是类名称，首字母小写
 * UserService --------userService
 */
// @Component(value = "userService")       //<bean id="userService" class="">注解中的value等价于xml中bean标签里的id属性
@Service
public class UserService {
    @Value(value = "JavaEE是怎样练成的")
    private String name;

    //定义dao类型属性
    //不需要添加set方法，注解方式已经对此过程做了封装
    //添加注入属性注解   //根据类型进行注入
    // @Autowired
    // @Qualifier(value = "userDaoImpl1")      //根据属性名称进行注入
    // private UserDao userDao;

    // @Resource       //根据类型注入
    @Resource(name = "userDaoImpl1")        //根据名称注入
    private UserDao userDao;


    public void add() {
        System.out.println("Add Service.........." + name);
        userDao.add();
    }
}
