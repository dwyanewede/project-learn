package com.learn.demo.interfaces.loan.product.function;

import com.learn.demo.interfaces.loan.product.LoanCommand;
import com.learn.demo.interfaces.loan.product.ProductInterface;
import com.learn.demo.interfaces.loan.product.function.appprocuct.AppCreditApplyCommand;
import com.learn.demo.interfaces.loan.product.function.appprocuct.AppCreditLimitSelectCommand;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: FunctionProductMain
 * @Description: 函数式编程，松耦合实现 {@link ProductInterface}
 * @Author: 尚先生
 * @CreateDate: 2019/5/10 14:38
 * @Version: 1.0
 */
public class FunctionProductMain {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {

        // 此处模拟 rpc 服务进来根据 产品代码 + 渠道标识 获得对应的 ProductInterface 对象
        // 即可以有除了 DefaultProduct 之外的多个产品
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.learn.demo.interfaces.loan.product");
        context.refresh();

        // 基础服务调用
        baseServiceCall(context);

        // 扩展服务调用
        // ...扩展实现同上面
    }

    /**
     * 基础服务调用
     * @param context
     */
    private static void baseServiceCall(AnnotationConfigApplicationContext context) {
        // 执行 授信实际调用
        FunctionProduct functionProduct = context.getBean("functionProduct", FunctionProduct.class);
        LoanCommand appCreditApplyCommand = context.getBean("appCreditApply", AppCreditApplyCommand.class);
        LoanCommand appCreditLimitSelectCommand = context.getBean("appCreditLimitSelect", AppCreditLimitSelectCommand.class);

        // 由于返回类型写的是 R 所以 需要强转 返回的 Object resMap1
        // 执行 额度查询实际调用

        // TODO 1.简单实现
//        functionProduct.setService(appCreditApplyFunction);
//        Object resMap1 = functionProduct.doCreditApply(appCreditApply -> {
//            return appCreditApplyFunction.doCreditApply(new HashMap<>());
//        });
//        printResultMsg((Map<String,Object>) resMap1);

        // 执行 额度查询实际调用
//        functionProduct.setService(appCreditLimitSelectFunction);
//        Object resMap2 = functionProduct.doCreditApply(appCreditLimitSelect -> {
//            return appCreditLimitSelectFunction.doCreditLimitSelect(new HashMap<>());
//        });
//        printResultMsg((Map<String,Object>) resMap2);

        // 其他服务调用亦是如此
        // ...

        // TODO 2.模拟多线程实现
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++){
            executorService.submit(() -> {
                Object resMap1 = functionProduct.doInvokeHandler(appCreditApply -> {
                    functionProduct.setService(appCreditApplyCommand);
                    return appCreditApplyCommand.execute(new HashMap<>());
                });
                printResultMsg((Map<String,Object>) resMap1);

                Object resMap2 = functionProduct.doInvokeHandler(appCreditLimitSelect -> {
                    functionProduct.setService(appCreditLimitSelectCommand);
                    return appCreditLimitSelectCommand.execute(new HashMap<>());
                });
                printResultMsg((Map<String,Object>) resMap2);
            });

        }
        executorService.shutdown();
    }

    /**
     * 打印响应信息
     * @param resMap
     */
    private static void printResultMsg(Map<String, Object> resMap) {
        int andIncrement = atomicInteger.getAndIncrement();
        System.err.println(resMap.get("msg") + "  rpc调用次数: " + andIncrement);
        resMap.forEach((code,msg) -> System.out.println(code + " : " + msg));
    }

}
