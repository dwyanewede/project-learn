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

    }

}
