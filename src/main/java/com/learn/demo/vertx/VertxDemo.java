package com.learn.demo.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

/**
 * @ClassName: VertxDemo
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/26 10:28
 * @Version: 1.0
 */
public class VertxDemo {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
//        vertx.setPeriodic(500,System.out::println);
//        vertx.setPeriodic(500,System.out::println);
//        vertx.setPeriodic(500,System.out::println);
//        Executors.newScheduledThreadPool(1)
//                .schedule(() -> System.out.println("sxs"),1000, TimeUnit.MILLISECONDS);
        vertxEventBusDemo(vertx);
        vertxDemo(vertx);
        vertx.close();
    }

    private static void vertxEventBusDemo(Vertx vertx) {
        String address = "test-address";
        // 事件订阅
        vertx.eventBus().consumer(address,message -> {

            Object body = message.body();
            System.err.printf("Address: %s -> message: %s\n", address, body);
        }).completionHandler(handler ->{
            System.err.println("消费完成...");
        });
        // 事件发布
        vertx.eventBus().publish(address, "hello world !");
        vertx.eventBus().publish(address, "sxs !");
    }


    private static void vertxDemo(Vertx vertx){
        vertx.deployVerticle(new AbstractVerticle() {
            @Override
            public void start(Future<Void> startFuture) throws Exception {
                System.out.println("start");
                startFuture.complete();
            }

            @Override
            public void stop(Future<Void> stopFuture) throws Exception {
                System.out.println("stop");
            }
        });
    }
}
