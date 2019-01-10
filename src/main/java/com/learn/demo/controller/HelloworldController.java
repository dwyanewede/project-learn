package com.learn.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloworldController
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/5 11:23
 * @Version: 1.0
 */
@RestController
public class HelloworldController {

    @GetMapping("/hello")
    public String helloWorld(@RequestParam String msg){
        return "hello world! "  + msg;
    }
}
