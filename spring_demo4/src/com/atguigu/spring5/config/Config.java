package com.atguigu.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 完全注解开发
 */
@Configuration      //开启注解配置
@ComponentScan(basePackages = {"com.atguigu.spring5"})      //开启组件扫描
@EnableAspectJAutoProxy(proxyTargetClass = true)    //开启Aspect生成代理对象
public class Config {
}
