package com.learn.demo.reactive;

import java.util.concurrent.CompletableFuture;

public class ChainDataLoader extends DataLoader {
    protected void doLoad() {
        CompletableFuture
                .runAsync(super::loadConfigurations)
                .thenRun(super::loadUsers)
                .thenRun(super::loadOrders)
                .whenComplete((result, throwable) -> { // 完成时回调
                    System.out.println("加载完成");
                })
                .join(); // 等待完成
    }

    public static void main(String[] args) {
        new ChainDataLoader().load();
    }
}