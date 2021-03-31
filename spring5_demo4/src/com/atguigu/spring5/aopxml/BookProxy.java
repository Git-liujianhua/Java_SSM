package com.atguigu.spring5.aopxml;

//增强类
public class BookProxy {

    public void before() {
        System.out.println("book buy before.............");
    }
}
