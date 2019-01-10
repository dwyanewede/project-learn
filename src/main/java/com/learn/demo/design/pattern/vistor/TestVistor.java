package com.learn.demo.design.pattern.vistor;

/**
 * @ClassName: TestVistor
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/20 8:56
 * @Version: 1.0
 */
public class TestVistor {

    public static void main(String[] args) {

        WeiBoVistor weiBoVistor = new WeiBoVistor();

        WeiChatVistor weiChatVistor = new WeiChatVistor();

        IQiYiLoginImpl iQiYiLogin = new IQiYiLoginImpl();

        weiBoVistor.visit(iQiYiLogin);

        weiChatVistor.visit(iQiYiLogin);

//        System.out.println("------------------------------------");
//
//        iQiYiLogin.accept(weiBoVistor);
    }
}
