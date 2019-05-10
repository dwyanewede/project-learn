package com.learn.demo.interfaces.loan.product.command;

import com.learn.demo.interfaces.loan.product.common.ApplicationContextUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DefaultProduct
 * @Description: 产品默认实现 AbstractProductInterface {@link AppProduct}
 * @Author: 尚先生
 * @CreateDate: 2019/5/10 11:30
 * @Version: 1.0
 */
@Service
public class DefaultProduct extends AbstractProductInterface {

    @Override
    public Map<String, Object> doCustRegister(Map<String, Object> reqMap) {
        // 可调用父类短信服务
        super.sendMsg(new HashMap<>());
        return null;
    }

    @Override
    public Map<String, Object> doSignCreditReportFile(Map<String, Object> reqMap) {
        return null;
    }

    @Override
    public Map<String, Object> doCreditApply(Map<String, Object> reqMap) {
        // 实现授信申请调用 beanName可由 reqMap 传入
        AppCreditApplyCommand appCreditApplyCommand = ApplicationContextUtils.getBean("appCreditApplyCommand", AppCreditApplyCommand.class);
        return appCreditApplyCommand.execute(reqMap);
    }

    @Override
    public Map<String, Object> doCreditApplySelect(Map<String, Object> reqMap) {
        // 实现额度查询调用 beanName可由 reqMap 传入
        AppCreditLimitSelectCommand appCreditLimitSelectCommand = ApplicationContextUtils.getBean("appCreditLimitSelectCommand", AppCreditLimitSelectCommand.class);
        return appCreditLimitSelectCommand.execute(reqMap);
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
