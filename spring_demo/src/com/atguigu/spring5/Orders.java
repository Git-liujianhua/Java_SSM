package com.atguigu.spring5;

/**
 * 使用有参数构造注入
 */
public class Orders {

    private String oname;
    private String address;

    //有参构造器
    public Orders(String oname, String address) {
        this.oname = oname;
        this.address = address;
    }

    public void addOrders() {
        System.out.println("订单：" + oname + ",地址：" + address);
    }
}
