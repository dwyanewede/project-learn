package com.learn.demo.interfaces.loan.product;

import com.learn.demo.interfaces.loan.product.ProductInterface;

import java.util.Map;

/**
 * @ClassName: ExtendProductInterface
 * @Description: 扩展实现 ProductInterface {@link ProductInterface}
 * @Author: 尚先生
 * @CreateDate: 2019/5/10 13:19
 * @Version: 1.0
 */
public interface ExtendProductInterface extends ProductInterface {

    // 开立个人账户
    Map<String,Object> doOpenPersonAccount(Map<String,Object> reqMap);

    // 开立企业账户
    Map<String,Object> doOpenOrgAccount(Map<String,Object> reqMap);
}
