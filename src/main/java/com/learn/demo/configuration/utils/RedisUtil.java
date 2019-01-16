package com.learn.demo.configuration.utils;

import org.springframework.data.redis.connection.SortParameters;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.query.SortQuery;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: RedisUtil
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2019/1/16 9:11
 * @Version: 1.0
 */
public class RedisUtil {

    private RedisTemplate<String, Object> redisTemplate;

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    /**
     * 普通缓存获取
     * @param key 键
     * @return 值
     */
    public Object get(String key){
        return key==null?null:redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     * @param key 键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean set(String key,Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 普通sort缓存放入
     * @param key 键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean setSort(String key,Object value) {
        try {
            SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
            setOperations.add(key,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    /**
     * 普通getSort缓存取出
     * @param key 键
     * @return BoundListOperations
     */
    public Set<Object> getSort(String key) {
        try {
            Set<Object> members = redisTemplate.opsForSet().members(key);
            return members;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    /**
     * 有序sorted缓存放入
     * @param key 键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean setSorted(String key,Object value,Double score) {
        try {
            ZSetOperations<String, Object> zSet = redisTemplate.opsForZSet();
            zSet.add(key, value, score);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    /**
     * 有序sorted缓存取出
     * @param key 键
     * @return BoundListOperations
     */
    public Set<Object> getSorted(String key, int start, int end) {
        try {
            Set<Object> range = redisTemplate.opsForZSet().range(key, start, end);
            return range;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
