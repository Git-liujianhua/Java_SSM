package com.atguigu.spring5;

/**
 * 演示使用set方法进行注入属性
 */
public class Book {

    private String bname;

    private String bauthor;

    private String address;


    //set方法注入
    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void setAddress(String address) {
        this.address = address;
    }
// //有参构造注入
    // public Book(String bname) {
    //     this.bname = bname;
    // }
    //

    public void addBook() {
        System.out.println("书名：" + bname + ",作者：" + bauthor + ",作者地址：" + address);
    }
    // public static void main(String[] args) {
    //     // Book book = new Book("aaa");
    //     Book book = new Book();
    //     book.setBname("aaa");
    // }
}
