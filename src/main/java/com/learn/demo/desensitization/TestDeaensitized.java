package com.learn.demo.desensitization;

import java.util.HashMap;

/**
 * @ClassName: TestDeaensitized
 * @Description: 日志脱敏测试类
 * @Author: 尚先生
 * @CreateDate: 2019/1/24 18:27
 * @Version: 1.0
 */
public class TestDeaensitized {

    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("custName", "尚先生");
        hashMap.put("certNo", "12345678909876543");
        hashMap.put("phone", "12345678909");
        System.out.println("脱敏前：" + hashMap);
        String converent1 = DesensitizedUtils.getConverent(hashMap);
        System.out.println("脱敏后：" + converent1);
        Person person = new Person();
        person.setCertNo("12345678909876541");
        person.setCustName("尚先生你真帅！");
        System.out.println("脱敏前：" + person);
        String converent2 = DesensitizedUtils.getConverent(person);
        System.out.println("脱敏后：" + converent2);
    }
}
