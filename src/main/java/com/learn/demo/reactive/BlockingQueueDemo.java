package com.learn.demo.reactive;


import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName: BlockingQueueDemo
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/24 11:04
 * @Version: 1.0
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        Flowable.just("Hello world").subscribe(System.out::println);

        Flowable.fromCallable(() -> {
            Thread.sleep(1000); //  imitate expensive computation
            System.out.println("thread..." + Thread.currentThread().getName());
            return "Done";
        }).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println, Throwable::printStackTrace);
        Thread.sleep(2000); // <--- wait for the flow to finish

        System.out.println("-------------------------------------------");

//        Observable<String> fromCallable =
        Observable.fromCallable(() -> {
            return "sxs";
        })
       .observeOn(Schedulers.single())
       .subscribe(System.out::println, Throwable::printStackTrace);;

    }

}
