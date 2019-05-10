package com.learn.demo.interfaces.loan.product.command;

import com.learn.demo.interfaces.loan.product.ProductInterface;

import java.util.Map;

/**
 * @ClassName: AbstractProductInterface
 * @Description: 抽象类实现 ProductInterface，可扩展基础功能服务，类似于短信发送等 {@link ProductInterface}
 * @Author: 尚先生
 * @CreateDate: 2019/5/10 11:30
 * @Version: 1.0
 */
public abstract class AbstractProductInterface implements ProductInterface {

    // 扩展短信发送服务功能
    public boolean sendMsg(Map<String,Object> smsMap){
        System.out.println("从 AbstractProductInterface smsMap 中取出对应参数，发送短信");
        // TODO rpc 调用短信发送服务接口
        return true;
    }


    @Override
    public Map<String, Object> doCustRegister(Map<String, Object> reqMap) {
        return null;
    }

    @Override
    public Map<String, Object> doSignCreditReportFile(Map<String, Object> reqMap) {
        return null;
    }

    @Override
    public Map<String, Object> doCreditApply(Map<String, Object> reqMap) {
        return null;
    }

    @Override
    public Map<String, Object> doCreditApplySelect(Map<String, Object> reqMap) {
        return null;
    }

    @Override
    public Map<String, Object> doCreditLimitSelect(Map<String, Object> reqMap) {
        return null;
    }

    @Override
    public Map<String, Object> doSignContractFile(Map<String, Object> reqMap) {
        return null;
    }

    @Override
    public Map<String, Object> doPayoutMoney(Map<String, Object> reqMap) {
        return null;
    }

    @Override
    public Map<String, Object> doDuebillSelect(Map<String, Object> reqMap) {
        return null;
    }

    @Override
    public Map<String, Object> doRepayPlanSelect(Map<String, Object> reqMap) {
        return null;
    }

    @Override
    public Map<String, Object> doRepayMoney(Map<String, Object> reqMap) {
        return null;
    }
}
