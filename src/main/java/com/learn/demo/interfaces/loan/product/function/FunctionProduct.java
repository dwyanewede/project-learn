package com.learn.demo.interfaces.loan.product.function;


import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.function.Function;

/**
 * @ClassName: FunctionProduct
 * @Description: Function 函数式接口实现 ProductInterface 接口服务调用
 * @Author: 尚先生
 * @CreateDate: 2019/5/10 11:36
 * @Version: 1.0
 */
@Component
public class FunctionProduct<T> {

    private T service;

    public void setService(T service) {
        this.service = service;
    }

    // TODO 另一种实现方式 new Object()实现
//    public FunctionProductInterface(T service) {
//        this.service = service;
//    }

    // 同样扩展短信发送服务功能
    public boolean sendMsg(Map<String,Object> smsMap){
        System.out.println("从FunctionProductInterface smsMap 中取出对应参数，发送短信");
        // TODO rpc 调用短信发送服务接口
        return true;
    }

    // 具体的服务调用抽象服务
    public <R> R doInvokeHandler(Function<T,R> function) {
        return function.apply(service);
    }


    /** 实际上下面的方法都可以由 {@link FunctionProduct#doInvokeHandler} 代替实现 故此，下面的代码不具备参考价值**/
    /*
    public <R> R doCustRegister(Function<T,R> function) {
        return function.apply(service);
    }

    public <R> R doSignCreditReportFile(Function<T,R> function) {
        return function.apply(service);
    }

    public <R> R doCreditApply(Function<T,R> function) {
        return function.apply(service);
    }

    public <R> R doCreditApplySelect(Function<T,R> function) {
        return function.apply(service);
    }

    public <R> R doCreditLimitSelect(Function<T,R> function) {
        return function.apply(service);
    }

    public <R> R doSignContractFile(Function<T,R> function) {
        return function.apply(service);
    }

    public <R> R doPayoutMoney(Function<T,R> function) {
        return function.apply(service);
    }

    public <R> R doDuebillSelect(Function<T,R> function) {
        return function.apply(service);
    }

    public <R> R doRepayPlanSelect(Function<T,R> function) {
        return function.apply(service);
    }

    public <R> R doRepayMoney(Function<T,R> function) {
        return function.apply(service);
    }*/

}
