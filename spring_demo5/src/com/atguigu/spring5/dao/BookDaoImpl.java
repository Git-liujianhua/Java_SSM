package com.atguigu.spring5.dao;

import com.atguigu.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加的方法
    @Override
    public void add(Book book) {
        //1、创建sql语句
        String sql = "insert into t_book (user_id,username,ustatus) values(?,?,?)";
        //2、调用方法实现
        //参数部分是一个可变参数，可变参数其实就是一个数组形式的参数
        Object[] args = {book.getUserId(), book.getUsername(), book.getUstatus()};
        int update = jdbcTemplate.update(sql, args);

        System.out.println(update);
    }

    //修改的方法
    @Override
    public void updateBook(Book book) {
        String sql = "update t_book set username = ? , ustatus = ? where user_id = ?";
        Object[] args = {book.getUsername(), book.getUstatus(), book.getUserId()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    // 删除的方法
    @Override
    public void delete(String id) {
        String sql = "delete from t_book where user_id = ?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }

    //查询返回某个值
    @Override
    public int selectCount() {
        String sql = "select count(*) from t_book";
        Integer query = jdbcTemplate.queryForObject(sql, Integer.class);
        return query;
    }

    //查询返回对象
    @Override
    public Book findBookInfo(String id) {
        String sql = "select user_id,username,ustatus from t_book where user_id = ?";
        //调用方法
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    //查询返回集合
    @Override
    public List<Book> findAllBook() {
        String sql = "select user_id,username,ustatus from t_book";
        List<Book> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return query;
    }

    //批量添加
    @Override
    public void batchAddBook(List<Object[]> args) {
        String sql = "insert into t_book (user_id,username,ustatus) values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, args);
        System.out.println(Arrays.toString(ints));
    }

    //批量修改
    @Override
    public void batchUpdate(List<Object[]> args) {
        String sql = "update t_book set username = ? , ustatus = ? where user_id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, args);
        System.out.println(Arrays.toString(ints));
    }

    //批量删除
    @Override
    public void batchDelet(List<Object[]> args) {
        String sql = "delete from t_book where user_id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, args);
        System.out.println(Arrays.toString(ints));
    }
}
