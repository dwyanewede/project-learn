package com.learn.demo.design.pattern.vistor;

/**
 * @ClassName: Visitor
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/19 19:24
 * @Version: 1.0
 */
public interface Visitor {

//    void visitIQiYi(Login login);
//
//    void visitYouKu(Login login);

    void visit(Login login);
}
