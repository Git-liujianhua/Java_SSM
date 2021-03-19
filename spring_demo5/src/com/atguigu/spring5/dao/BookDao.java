package com.atguigu.spring5.dao;

import com.atguigu.spring5.entity.Book;

import java.util.List;

public interface BookDao {

    //添加
    public void add(Book book);

    //修改
    public void updateBook(Book book);

    //删除
    public void delete(String id);

    //查询返回某个值
    public int selectCount();

    //查询返回对象
    public Book findBookInfo(String id);

    //查询返回集合
    public List<Book> findAllBook();

    //批量添加
    public void batchAddBook(List<Object[]> args);

    //批量修改
    public void batchUpdate(List<Object[]> args);

    //批量删除
    public void batchDelet(List<Object[]> args);
}
