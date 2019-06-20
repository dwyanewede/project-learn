package com.learn.demo.java.base.trycatchfinally;

import java.util.HashMap;
import java.util.Map;

public class FinallyTest6
{
    public static void main(String[] args) {
        System.out.println(getMap().get("KEY").toString()); // FINALLY
    }
     
    public static Map<String, String> getMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("KEY", "INIT");
         
        try {
            map.put("KEY", "TRY");
            return map;
        }
        catch (Exception e) {
            map.put("KEY", "CATCH");
        }
        finally {
            map.put("KEY", "FINALLY");
            map = null;
        }
        return map;
    }

    //  为什么测试用例1中finally里的b = 150;
    // 并没有起到作用而测试用例2中finally的map.put(“KEY”, “FINALLY”);起了作用而map = null;却没起作用呢？

    // Answer
    // Java中只有传值没有传址，这也是为什么map = null这句不起作用
    // 这同时也说明了返回语句是try中的return语句而不是 finally外面的return b;这句
}
