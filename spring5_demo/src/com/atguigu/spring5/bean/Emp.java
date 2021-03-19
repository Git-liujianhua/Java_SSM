package com.atguigu.spring5.bean;

import org.junit.Test;

//员工类
public class Emp {

    private String ename;
    private String gender;
    //员工属于某个部门，使用对象的形式表示
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void add() {
        System.out.println("姓名：" + ename + "，性别：" + gender + "，部门：" + dept);
    }
}
