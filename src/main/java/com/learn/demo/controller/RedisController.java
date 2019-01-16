package com.learn.demo.controller;

import com.learn.demo.configuration.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @ClassName: RedisController
 * @Description: 测试redis各种数据存储类型
 * @Author: 尚先生
 * @CreateDate: 2019/1/16 9:58
 * @Version: 1.0
 */
@RestController
public class RedisController {
    @Autowired
    private RedisUtil redisUtil;

/*127.0.0.1:6379> lpush mimvp 12
(integer) 1
127.0.0.1:6379> lpush mimvp 11
(integer) 2
127.0.0.1:6379> lpush mimvp 13
(integer) 3
127.0.0.1:6379> lpush mimvp 10
(integer) 4
127.0.0.1:6379> lrange mimvp 0 -1*/

/*redis 127.0.0.1:6379> ZADD runoobkey 1 redis
(integer) 1
redis 127.0.0.1:6379> ZADD runoobkey 2 mongodb
(integer) 1
redis 127.0.0.1:6379> ZADD runoobkey 3 mysql
(integer) 1
redis 127.0.0.1:6379> ZADD runoobkey 3 mysql
(integer) 0
redis 127.0.0.1:6379> ZADD runoobkey 4 mysql
(integer) 0
redis 127.0.0.1:6379> ZRANGE runoobkey 0 10 WITHSCORES*/

    @GetMapping("/redis")
    public String helloWorld(@RequestParam String msg) {

        //普通get set方法
        // boolean set = redisUtil.set("hello", "world");
        // System.out.println("添加redis：" + set);

        // 普通集合set
        redisUtil.setSort("mimvp", 11);
        redisUtil.setSort("mimvp", 12);
        redisUtil.setSort("mimvp", 13);
        redisUtil.setSort("mimvp", 14);
        redisUtil.setSort("mimvp", 15);
        redisUtil.setSort("mimvp", 15);
        redisUtil.setSort("mimvp", 15);
        boolean setSort = redisUtil.setSort("mimvp", 16);
        System.err.println("添加redis：" + setSort);
        Set<Object> res = redisUtil.getSort("mimvp");
        res.forEach(exe -> System.err.println(exe.toString()));

        //有序集合sorded
        redisUtil.setSorted("runoobkey","redis",Double.parseDouble("2"));
        redisUtil.setSorted("runoobkey","mongodb",Double.parseDouble("3"));
        redisUtil.setSorted("runoobkey","mysql",Double.parseDouble("4"));
        redisUtil.setSorted("runoobkey","mysql",Double.parseDouble("5"));
        redisUtil.setSorted("runoobkey","mysql",Double.parseDouble("5"));
        System.out.println("--------------有序集合sorded 添加成功-------------------");

        Set<Object> objects = redisUtil.getSorted("runoobkey", 0, -1);
        objects.forEach(exe -> System.err.println(exe.toString()));
        return "hello world! " + msg;
    }
}
