package com.atguigu.spring5;

import javax.jws.soap.SOAPBinding;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {

    public static void main(String[] args) {

        //创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
        // Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
        //     @Override
        //     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //         return null;
        //     }
        // });
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        // int result = dao.add(1, 2);
        // System.out.println(result);
        String update = dao.update("1");
        System.out.println(update);
    }
}

//创建代理对象代码
class UserDaoProxy implements InvocationHandler {

    //1、把创建的是谁的代理对象，把谁传递过来
    //有参构造传递
    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //执行方法前
        System.out.println("方法执行之前...." + method.getName() + Arrays.toString(args));
        Object res = null;
        if (method.getName() == "add") {
            //执行的被增强的方法
            res = method.invoke(obj, args);
            System.out.println("add 增强........");
        } else {
            //执行的被增强的方法
            res = method.invoke(obj, args);
            System.out.println("update 增强.........");
        }


        //执行方法后
        System.out.println("方法执行之后....." + obj);
        return res;
    }
}
