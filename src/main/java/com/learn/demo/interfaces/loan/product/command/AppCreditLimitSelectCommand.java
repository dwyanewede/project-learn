package com.learn.demo.interfaces.loan.product.command;

import com.learn.demo.interfaces.loan.product.LoanCommand;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AppCreditLimitSelectCommand
 * @Description: APP 额度查询具体实现类   {@link LoanCommand}
 * @Author: 尚先生
 * @CreateDate: 2019/5/10 11:58
 * @Version: 1.0
 */
@Service
public class AppCreditLimitSelectCommand implements LoanCommand{

    @Override
    public Map<String, Object> execute(Map<String, Object> reqMap) {
        System.out.println("开始 App 额度查询");
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("code","0000");
        resMap.put("msg","额度查询成功");
        return resMap;
    }
}
