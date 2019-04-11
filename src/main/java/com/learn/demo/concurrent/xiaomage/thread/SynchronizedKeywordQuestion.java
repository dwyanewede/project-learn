package com.learn.demo.concurrent.xiaomage.thread;

public class SynchronizedKeywordQuestion {

    public static void main(String[] args) {

    }

    private static void synchronizedBlock() {
        synchronized (SynchronizedKeywordQuestion.class) {
        }
    }

    private synchronized static void synchronizedMethod() {
    }
}
