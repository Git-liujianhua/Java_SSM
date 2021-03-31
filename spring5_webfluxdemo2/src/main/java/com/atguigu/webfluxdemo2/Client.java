package com.atguigu.webfluxdemo2;

import com.atguigu.webfluxdemo2.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * 客户端的调用
 */
public class Client {

    public static void main(String[] args) {

        //创建WebClient对象指定服务器地址调用服务i去地址
        WebClient webClient = WebClient.create("http://localhost:60484");

        String id = "1";
        //更具id查询
        //webClient.get()  发送请求查询提交get方法
        //uri("/users/{id}", id) 指定路径两个参数：一个是请求路劲，一个是请求参数
        //accept(MediaType.APPLICATION_JSON) 指定现在接收的类型
        //retrieve() 初始化操作处理
        //bodyToMono(User.class)  获取mono流中的数据加上返回类型的class
        //block()  最终执行
        User userresult = webClient.get().uri("/users/{id}", id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(User.class).block();

        System.out.println(userresult.getName());


        //查询所有
        //bodyToFlux(User.class)  返回多个元素在里边使用bodyToFlux(User.class)方法
        Flux<User> userFlux = webClient.get().uri("/users").accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(User.class);

        //stu.getName()  获取
        //buffer()  缓冲
        //doOnNext(System.out::println)  一行一行往下执行输出
        //blockFirst();最终执行类似于订阅的一个过程
        userFlux.map(stu -> stu.getName()).buffer().doOnNext(System.out::println).blockFirst();
    }
}
