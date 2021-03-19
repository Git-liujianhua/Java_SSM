package com.atguigu.webfluxdemo2.handler;

import com.atguigu.webfluxdemo2.entity.User;
import com.atguigu.webfluxdemo2.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class UserHandler {

    private final UserService userService;

    public UserHandler(UserService userService){
        this.userService = userService;
    }

    //根据Id查询
    //函数式编程第一种写法
    public Mono<ServerResponse> getUserById(ServerRequest request){
        //获取Id值
        Integer id = Integer.valueOf(request.pathVariable("id"));

        //空值处理
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        //调用service方法获取数据
        Mono<User> userMono = this.userService.getUserById(id);

        //把userMono转换为流进行返回
        //使用Reactor操作符flatMap
        //ServerResponse.ok()表示操作成功
        //contentType(MediaType.APPLICATION_JSON)返回什么类型，常量是MediaType.APPLICATION_JSON
        //.body(fromObject(person)))转变类型
        //switchIfEmpty(notFound);判断是否为空
        return userMono.flatMap(person -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(person))).switchIfEmpty(notFound);

    }

    //查询所有
    //函数式编程第二种写法
    public Mono<ServerResponse> getAllUser(ServerRequest request){
        //调用Service方法获取数据
        Flux<User> userFlux = this.userService.getAllUser();

        //把userFlux转换为流进行返回
       return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userFlux,User.class);
    }

    //添加
    public Mono<ServerResponse> saveUser(ServerRequest request){
        //得到user对象
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().build(this.userService.saveUserInfo(userMono));
    }

}
