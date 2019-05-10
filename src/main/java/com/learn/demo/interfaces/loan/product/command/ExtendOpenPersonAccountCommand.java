package com.learn.demo.interfaces.loan.product.command;

import com.learn.demo.interfaces.loan.product.LoanCommand;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ExtendOpenPersonAccountCommand
 * @Description: 开立个人账户具体实现类   {@link LoanCommand}
 * @Author: 尚先生
 * @CreateDate: 2019/5/10 11:58
 * @Version: 1.0
 */
@Service
public class ExtendOpenPersonAccountCommand implements LoanCommand{

    @Override
    public Map<String, Object> execute(Map<String, Object> reqMap) {
        System.out.println("开始开立个人账户");
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("code","0000");
        resMap.put("msg","开立个人账户成功");
        return resMap;
    }
}
