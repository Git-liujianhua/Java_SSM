package com.atguigu.spring5.test;

import com.atguigu.spring5.entity.Book;
import com.atguigu.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestBook {
    @Test
    public void testTemplate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService userService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        //t添加
        // for (int i = 1 ; i < 10 ;i++){
        //     book.setUserId("0");
        //     book.setUsername("Spring");
        //     book.setUstatus("a");
        //     userService.addBook(book);
        // }
        //修改
        // book.setUserId("1");
        // book.setUsername("Spring5");
        // book.setUstatus("b");
        // userService.updateBook(book);
        //删除
        // userService.delete("1");
        //查询返回某个值
        // int count = userService.findCount();
        // System.out.println(count);

        //查询返回对象
        // Book findBook = userService.findOne("4");
        // System.out.println(findBook);

        //查询返回集合
        // List<Book> all = userService.findAll();
        // System.out.println(all);

        //批量添加
        // List<Object[]> args = new ArrayList<>();
        // Object[] o1 = {"10","Spring","c"};
        // Object[] o2 = {"11","SpringMVC","c"};
        // Object[] o3 = {"12","MyBatis","c"};
        // args.add(o1);
        // args.add(o2);
        // args.add(o3);
        // //调用方法实现批量添加
        // userService.batchAdd(args);


        // //批量修改
        // List<Object[]> args = new ArrayList<>();
        // Object[] o1 = {"Java","c","1"};
        // Object[] o2 = {"JavaEE","c","2"};
        // Object[] o3 = {"PHP","c","3"};
        // args.add(o1);
        // args.add(o2);
        // args.add(o3);
        // //调用方法实现批量修改
        // userService.batchUpdate(args);

        //批量删除
        // List<Object[]> args = new ArrayList<>();
        // Object[] o1 = {"4"};
        // Object[] o2 = {"5"};
        // Object[] o3 = {"6"};
        // args.add(o1);
        // args.add(o2);
        // args.add(o3);
        // //调用方法实现批量删除
        // userService.batchDelet(args);

        int i = 12;
        int a = i += i -= i *= i;
        System.out.println(a);
    }
}
