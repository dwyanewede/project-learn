package com.learn.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: UserController
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/13 19:00
 * @Version: 1.0
 */
@RestController
public class UserController {

    @Autowired
    private RemoteUserService remoteUserService;

    public List<User> findAll(){
        return remoteUserService.findAll();
    }
}
