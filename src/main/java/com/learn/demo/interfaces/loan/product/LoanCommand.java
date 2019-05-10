package com.learn.demo.interfaces.loan.product;

import java.util.Map;

/**
 * @ClassName: LoanCommand
 * @Description: 命令接口抽象，使用的设计模式：命令模式
 * @Author: 尚先生
 * @CreateDate: 2019/5/10 11:56
 * @Version: 1.0
 */
public interface LoanCommand {

    public Map<String, Object> execute (Map<String, Object> reqMap);
}
