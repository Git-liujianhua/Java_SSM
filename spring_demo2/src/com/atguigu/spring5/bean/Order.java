package com.atguigu.spring5.bean;

public class Order {

    private String oname;

    // 1）通过构造器创建Bean实例（无参构造器）
    public Order() {
        System.out.println("第一步 执行无参构造器创建bean实例");
    }

    // 2）为Bean的属性设置值和对其他Bean引用（调用set方法）
    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二步 调用set方法为bean的属性设置值");
    }

    // 3）调用Bean的初始化的方法（需要进行配置初始化的方法）
    public void initMethod() {
        System.out.println("第四步 执行初始化方法");
    }

    // 5）当容器关闭的时候，调用Bean的销毁的方法（需要进行配置销毁的方法）
    public void destroyMethod() {
        System.out.println("第七步 调用bean的销毁的方法");
    }
}
