package com.atguigu.spring5.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class PersonProxy {

    @Before("execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void personBefore() {
        System.out.println("person before..........");
    }
}
