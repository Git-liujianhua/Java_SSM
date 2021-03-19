package com.atguigu.spring5.collectiontype;

import java.util.List;

public class Book {

    private List<String> bname;

    public void setBname(List<String> bname) {
        this.bname = bname;
    }

    public void test() {
        System.out.println(bname);
    }
}
