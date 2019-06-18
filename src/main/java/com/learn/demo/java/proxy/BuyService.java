package com.learn.demo.java.proxy;

/**
 * @ClassName: BuyService
 * @Description: 购买基础接口
 * @Author: 尚先生
 * @CreateDate: 2019/6/17 14:52
 * @Version: 1.0
 */
public interface BuyService {

    String buyPhone(BuyService buyService);

    String buyComputer(BuyService buyService);

}
