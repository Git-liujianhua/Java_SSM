package com.atguigu.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //少钱的方法(lucy转账100给mary)
    @Override
    public void reduceMoney() {
        String sql = "update t_account set money=money - ? where username = ?";
        jdbcTemplate.update(sql, 100, "lucy");
    }

    //多钱的方法(mary得到lucy转账过来的100)
    @Override
    public void addMoney() {
        String sql = "update t_account set money = money + ? where username = ?";
        jdbcTemplate.update(sql, 100, "mary");
    }

}
