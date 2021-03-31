package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.BookDao;
import com.atguigu.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    //注入dao
    @Autowired
    private BookDao bookDao;

    //添加图书
    public void addBook(Book book) {
        bookDao.add(book);
    }

    //修改图书
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    //删除图书
    public void delete(String id) {
        bookDao.delete(id);
    }

    //查询数据库中的记录数（返回某个值）
    public int findCount() {
        return bookDao.selectCount();
    }

    //查询数据库返回对象
    public Book findOne(String id) {
        return bookDao.findBookInfo(id);
    }

    //查询数据库返回集合
    public List<Book> findAll() {
        return bookDao.findAllBook();
    }

    //批量添加
    public void batchAdd(List<Object[]> args) {
        bookDao.batchAddBook(args);
    }

    //批量修改
    public void batchUpdate(List<Object[]> args) {
        bookDao.batchUpdate(args);
    }

    //批量删除
    public void batchDelet(List<Object[]> args) {
        bookDao.batchDelet(args);
    }
}
