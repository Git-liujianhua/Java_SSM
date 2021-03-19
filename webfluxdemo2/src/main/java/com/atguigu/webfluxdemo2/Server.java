package com.atguigu.webfluxdemo2;

import com.atguigu.webfluxdemo2.handler.UserHandler;
import com.atguigu.webfluxdemo2.service.UserService;
import com.atguigu.webfluxdemo2.service.impl.UserServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

/**
 * 路由、适配和服务器的创建
 */
public class Server {

    //1、创建Router路由
    public RouterFunction<ServerResponse> routingFunction(){
        //创建handler对象
        UserService userService = new UserServiceImpl();
        UserHandler userHandler = new UserHandler(userService);
        //设置路由
        return RouterFunctions.route(
                GET("/users/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),userHandler::getUserById)
                        .andRoute(GET("/users").and(accept(MediaType.APPLICATION_JSON)),userHandler::getAllUser);
    }

    //2、创建服务器完成适配
    public void createReactorServer(){
        //路由和Handle适配（路由执行具体的方法）
        RouterFunction<ServerResponse> route = routingFunction();
        HttpHandler httpHandler = toHttpHandler(route);
        ReactorHttpHandlerAdapter reactorHttpHandlerAdapter = new ReactorHttpHandlerAdapter(httpHandler);
        //创建服务器
        HttpServer httpServer = HttpServer.create();
        httpServer.handle(reactorHttpHandlerAdapter).bindNow();
    }

    //最终对服务器做一个调用并且启动服务器
    public static void main(String[] args) throws Exception{
        Server server = new Server();
        server.createReactorServer();
        System.out.println("enter to exit");
        System.in.read();
    }
}
