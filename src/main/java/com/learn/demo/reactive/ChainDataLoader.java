package com.learn.demo.reactive;

import java.util.concurrent.CompletableFuture;

public class ChainDataLoader extends DataLoader {
    protected void doLoad() {
        long startTime = System.currentTimeMillis(); // 开始时间
        CompletableFuture
                .runAsync(super::loadConfigurations)
                .thenRun(super::loadUsers)
                .thenRun(super::loadOrders)
                .whenComplete((result, throwable) -> { // 完成时回调
                    System.out.println("加载完成");
                })
                .join(); // 等待完成
        long costTime = System.currentTimeMillis() - startTime; // 消耗时间
        System.out.println("load() 总耗时：" + costTime + " 毫秒");
    }

    public static void main(String[] args) {
        new ChainDataLoader().doLoad();
    }
}