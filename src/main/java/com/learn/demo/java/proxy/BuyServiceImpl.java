package com.learn.demo.java.proxy;


import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: BusiServiceImpl
 * @Description: 购买实现类
 * @Author: 尚先生
 * @CreateDate: 2019/6/17 14:53
 * @Version: 1.0
 */
@Service
public class BuyServiceImpl implements BuyService {

    @Intercept("buyPhone")
    @Override
    public String buyPhone(BuyService buyService) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("==========当前类描述 " + buyService.getClass().getName() + "=============" + " buyPhone");
        this.buyComputer(this);
        return "buy phone";
    }

    @Intercept("buyComputer")
    @Override
    public String buyComputer(BuyService buyService) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("==========当前类描述 " + buyService.getClass().getName() + "=============" + " buyComputer");
        return "buy computer";
    }
}
