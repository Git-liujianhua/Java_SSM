package com.atguigu.spring5.test;

import org.junit.Test;

public class User {
        @Test
        public void test1() {
            String str = "ORD-2381";
            String sub = str.substring(str.indexOf("-")+1);
            String sub1 = str.substring(0,str.indexOf("-"));
            System.out.println(sub);
            System.out.println(sub1);
        }

}
