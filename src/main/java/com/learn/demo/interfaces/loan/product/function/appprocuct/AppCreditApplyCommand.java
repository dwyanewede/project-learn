package com.learn.demo.interfaces.loan.product.function.appprocuct;

import com.learn.demo.interfaces.loan.product.LoanCommand;
import com.learn.demo.interfaces.loan.product.ProductInterface;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AppCreditApplyCommand
 * @Description: APP 授信申请具体实现类  {@link LoanCommand} {@link ProductInterface}
 * @Author: 尚先生
 * @CreateDate: 2019/5/10 11:58
 * @Version: 1.0
 */
@Service(value = "app01CreditApply")
public class AppCreditApplyCommand implements LoanCommand{
    @Override
    public Map<String, Object> execute(Map<String, Object> reqMap) {
        System.out.println("开始 AppCreditApplyFunction 授信申请");
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("code","0000");
        resMap.put("msg","授信申请成功");
        return resMap;
    }
}
