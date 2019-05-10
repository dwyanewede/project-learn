package com.learn.demo.interfaces.loan.product.command;

import com.learn.demo.interfaces.loan.product.ExtendProductInterface;
import com.learn.demo.interfaces.loan.product.common.ApplicationContextUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @ClassName: DefaultExtendProduct
 * @Description: 默认实现 AbstractExtendProductInterface，可扩展基础功能服务，类似于短信发送等 {@link ExtendProductInterface}
 * @Author: 尚先生
 * @CreateDate: 2019/5/10 11:30
 * @Version: 1.0
 */
@Service
public class DefaultExtendProduct extends AbstractExtendProductInterface {

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


    /** 具体实现类似 {@link AppCreditApplyCommand}  {@link AppCreditLimitSelectCommand} **/
    @Override
    public Map<String, Object> doOpenPersonAccount(Map<String, Object> reqMap) {
        // 实现开立个人账户调用 beanName可由 reqMap 传入
        ExtendOpenPersonAccountCommand extendOpenPersonAccountCommand = ApplicationContextUtils.getBean("extendOpenPersonAccountCommand", ExtendOpenPersonAccountCommand.class);
        Map<String, Object> resMap = extendOpenPersonAccountCommand.execute(reqMap);

        // 发送开户成功短信
        if (Optional.ofNullable(resMap).get().containsValue("0000")){
            sendMsg(new HashMap<>());
        }
        return resMap;
    }

    @Override
    public Map<String, Object> doOpenOrgAccount(Map<String, Object> reqMap) {
        return null;
    }
}
