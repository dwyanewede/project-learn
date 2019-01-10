package com.learn.demo.design.pattern.vistor;

/**
 * @ClassName: IQiYiLoginImpl
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/19 19:30
 * @Version: 1.0
 */
public class IQiYiLoginImpl implements Login {
    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getSimpleName()+ " 访问者登录IQiYi");
//        visitor.visit(this);
    }
}
