package com.learn.demo.interfaces.loan.product;

import java.util.Map;

/**
 * @ClassName: ProductInterface
 * @Description: 产品基础接口，可继承扩展，使用的设计原则：接口隔离原则
 * @Author: 尚先生
 * @CreateDate: 2019/5/10 11:11
 * @Version: 1.0
 */
public interface ProductInterface {

    // 由于后续改造 rpc 传输的数据载体采用的是 Map，此次优先采用 Map 形式实现函数式接口实现
    // 后续如有需要，会进行相应扩展补充

    // 客户注册
    Map<String,Object> doCustRegister(Map<String,Object> reqMap);

    // 征信协议签署
    Map<String,Object> doSignCreditReportFile(Map<String,Object> reqMap);

    // 授信申请
    Map<String,Object> doCreditApply(Map<String,Object> reqMap);

    // 授信进度查询
    Map<String,Object> doCreditApplySelect(Map<String,Object> reqMap);

    // 额度查询
    Map<String,Object> doCreditLimitSelect(Map<String,Object> reqMap);

    // 合同签署
    Map<String,Object> doSignContractFile(Map<String,Object> reqMap);

    // 放款处理
    Map<String,Object> doPayoutMoney(Map<String,Object> reqMap);

    // 借据查询
    Map<String,Object> doDuebillSelect(Map<String,Object> reqMap);

    // 还款计划查询
    Map<String,Object> doRepayPlanSelect(Map<String,Object> reqMap);

    // 主动还款
    Map<String,Object> doRepayMoney(Map<String,Object> reqMap);
}
