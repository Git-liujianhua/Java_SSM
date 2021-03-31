package com.atguigu.webfluxdemo1.service.impl;

import com.atguigu.webfluxdemo1.entity.User;
import com.atguigu.webfluxdemo1.service.UserService;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
@Repository
public class UserServiceImpl implements UserService {

    //创建Map集合存储数据
    private final Map<Integer,User> users = new HashMap<Integer, User>();

    //创建UserServiceImpl无参构造器
    public UserServiceImpl(){
        this.users.put(1,new User("lucy","nan",20));
        this.users.put(2,new User("mary","nv",20));
        this.users.put(3,new User("jack","nv",50));
    }

    //根据id查询
    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(this.users.get(id));
    }

    //查询多个用户
    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.users.values());
    }

    //添加用户
    @Override
    public Mono<Void> saveUserInfo(Mono<User> userMono) {
        return userMono.doOnNext(person ->{
            //向map集合里面添加值
            int id = users.size()+1;
            users.put(id,person);
        }).thenEmpty(Mono.empty());//做空值的处理把Mono里边相关的值清空（操作之后把Mono里边的内容清空）让Mono结束，发送一个终止信号将数据流终止或加一个错误信号将流终止
    }
}
