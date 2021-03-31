package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
public class UserService {


    //注入dao
    @Autowired
    private UserDao userDao;

    //转账的方法
    public void accountMoney() {
        // try {
        //第一步：开启事务

        //第二步：进行业务操作
        //lucy多100
        userDao.reduceMoney();
        //模拟异常
        int i = 10 / 0;
        //mary少100
        userDao.addMoney();
        //第三步：如果没有异常，则提交事务
        // } catch (Exception e) {
        //第四步：如果出现异常，则回滚事务
        // e.printStackTrace();
        // }
    }
}
