package com.learn.demo.java.base;

import java.util.HashMap;

/**
 * @ClassName: HashCodeAndEquals
 * @Description: hashMap 重写 hashCode 和 equals
 * @Author: 尚先生
 * @CreateDate: 2019/5/30 8:48
 * @Version: 1.0
 */
class RewriteHashMap {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public RewriteHashMap(Integer id) {
        this.id = id;
    }
    //故意先注释掉equals和hashCode方法
//      public boolean equals(Object o) {
//          if (o == null || !(o instanceof RewriteHashMap))
//          { return false; }
//          else
//          { return this.getId().equals(((RewriteHashMap) o).getId());}
//      }

    public int hashCode() {
        return id.hashCode();
    }
}

public class HashCodeAndEquals {
    public static void main(String[] args) {
        RewriteHashMap k1 = new RewriteHashMap(1);
        RewriteHashMap k2 = new RewriteHashMap(1);
        HashMap<RewriteHashMap, String> hm = new HashMap<>();
        hm.put(k1, "Key with id is 1");
//        hm.put(k2, "Key with id is 2");
        System.out.println("get key1 result: " + hm.get(k1));
        System.out.println("get key2 result: " + hm.get(k2));

        int size = hm.size();

        System.out.println("hm 存储数据大小：" + size);

        System.out.println("-----------遍历输出结果-----------");
        hm.forEach((k, v) -> {
            System.out.println("k: " + k + "   " + "v: " + v);
        });


        System.out.println("++++++++++++++++++++++基本数据类型与包装数据类型对比+++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

//        int i = 100; // 1000
//        int k = 100; // 1000
//        Integer j = 100; // 1000
//        Integer x = 100; // 1000


        double i = 100.0; // 1000.0
        double k = 100.0; // 1000.0
        Double j = 100.0; // 1000.0
        Double x = 100.0; // 1000.0

        System.out.println(i == k);
        System.out.println(i == j);
        System.out.println(j == k);
        System.out.println(j == x);


        System.out.println(j.equals(i));
        System.out.println(i == j);
        System.out.println(j.equals(k));
        System.out.println(j.equals(x));

    }

}
