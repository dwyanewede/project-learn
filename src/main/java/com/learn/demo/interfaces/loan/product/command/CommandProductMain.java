package com.learn.demo.interfaces.loan.product.command;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CommandProductMain
 * @Description: 设计模式：工厂方法 + 命令模式实现
 * @Author: 尚先生
 * @CreateDate: 2019/5/10 12:54
 * @Version: 1.0
 */
public class CommandProductMain {

    public static void main(String[] args) {

        // 此处模拟 rpc 服务进来根据 产品代码 + 渠道标识 获得对应的 ProductInterface 对象
        // 即可以有除了 DefaultProduct 之外的多个产品
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.learn.demo.interfaces.loan.product");
        context.refresh();

        // 基础服务调用
        baseServiceCall(context);

        // 扩展服务调用
        extendServiceCall(context);
    }

    /**
     * 扩展服务调用
     * @param context
     */
    private static void extendServiceCall(AnnotationConfigApplicationContext context) {
        DefaultExtendProduct defaultExtendProduct = context.getBean("defaultExtendProduct", DefaultExtendProduct.class);
        Map<String, Object> resMap1 = defaultExtendProduct.doOpenPersonAccount(new HashMap<>());
        printResultMsg(resMap1);
    }

    /**
     * 基础服务调用
     * @param context
     */
    private static void baseServiceCall(AnnotationConfigApplicationContext context) {
        // 执行 授信实际调用
        DefaultProduct defaultProduct = context.getBean("defaultProduct", DefaultProduct.class);
        Map<String, Object> resMap1 = defaultProduct.doCreditApply(new HashMap<>());
        printResultMsg(resMap1);

        // 执行 额度查询实际调用
//        Map<String, Object> resMap2 = defaultProduct.doCreditApplySelect(new HashMap<>());
//        printResultMsg(resMap2);

        // 其他服务调用亦是如此
        // ...
    }

    /**
     * 打印响应信息
     * @param resMap
     */
    private static void printResultMsg(Map<String, Object> resMap) {
        resMap.forEach((code,msg) -> System.out.println(code + " : " + msg));
    }

}
