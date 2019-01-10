package com.learn.demo.design.pattern.vistor;

/**
 * @ClassName: WeiChatVistor
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/20 8:53
 * @Version: 1.0
 */
public class WeiChatVistor implements Visitor{
    @Override
    public void visit(Login login) {
        System.out.println("微信用户登录");
        login.accept(this);
    }
//    @Override
//    public void visitIQiYi(Login login) {
//        System.out.println("爱奇艺用户登录");
//        login.accept(this);
//    }
//
//    @Override
//    public void visitYouKu(Login login) {
//        System.out.println("优酷用户登录");
//        login.accept(this);
//    }
}
