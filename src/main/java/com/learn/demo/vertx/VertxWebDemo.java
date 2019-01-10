package com.learn.demo.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

/**
 * @ClassName: VertxWebDemo
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/26 14:49
 * @Version: 1.0
 */
public class VertxWebDemo {


    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        // 路由处理
        Router router = Router.router(vertx);
        router.get("/echo").handler(context -> {
            // 请求
            HttpServerRequest request = context.request();
            String msg = request.getParam("request");
            // 响应
            HttpServerResponse response = context.response();
            response.end("hello " + msg);
        });

        // 执行结果
        // 访问  http://localhost:8080/echo?request=123123
        // 页面显示 hello 123123

//        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
        // 等同于
        vertx.createHttpServer().requestHandler(handler ->{
            router.accept(handler);
        }).listen(8080);


        // 创建Http服务
//        vertx.createHttpServer().requestHandler(handler ->{
//            // 请求
//            String requestMsg = handler.getParam("request");
//            // 响应
//            HttpServerResponse response = handler.response();
//            response.end("hello " + requestMsg);
//            // 监听端口
//        }).listen(8080);
        // 执行结果
        // 访问  http://localhost:8080/?request=123
        // 页面显示 hello 123
    }
}
