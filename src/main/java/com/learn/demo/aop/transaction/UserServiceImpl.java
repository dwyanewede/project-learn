package com.learn.demo.aop.transaction;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2019/1/12 23:59
 * @Version: 1.0
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @MyTransaction
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
