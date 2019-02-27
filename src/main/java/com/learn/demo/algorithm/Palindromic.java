package com.learn.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Palindromic
 * @Description: 回文字符串
 * @Author: 尚先生
 * @CreateDate: 2019/2/27 14:46
 * @Version: 1.0
 */
public class Palindromic {


    public static void main(String[] args) {
        String res1 = getPailStr1("abcdexxxfgfyyedcba");
        String res2 = getPailStr2("abcdexxxfgfyyedcba");
        String res3 = longestPalindrome("abcdexxxfgfyyedcba");
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }



    /**
     * 实现方法三
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        // 如果回字符串长度小于2直接返回
        if(s.length() < 2) {
            return s;
        }
        // 记录最长的回文串
        String palindromic = "";
        int j, k;
        for(int i = 1; i < s.length(); i++) {
            if(s.length() - i <= palindromic.length() / 2) {
                break;
            }
            int sum = 1;
            // 奇数长度判断
            for(j = i - 1, k = i + 1; j >= 0 && k < s.length(); j--, k++) {
                if(s.charAt(j) != s.charAt(k)) {
                    break;
                }
                sum = sum + 2;
            }
            if(sum > palindromic.length()) {
                palindromic = s.substring(j + 1, k);
            }
            sum = 0;
            // 偶数长度判断
            for(j = i - 1, k = i; j >= 0 && k < s.length(); j--, k++) {
                if(s.charAt(j) != s.charAt(k)) {
                    break;
                }
                sum = sum + 2;
            }
            if(sum > palindromic.length()) {
                palindromic = s.substring(j + 1, k);
            }
        }
        return palindromic;
    }


    /**
     * 实现方法一
     * @param s
     * @return
     */
    public static String getPailStr1(String s){
        int n = s.length();
        String str = "";
        int maxNums = 0;
        List<Character> list = new ArrayList();
        List<Character> keyList = new ArrayList();
        int j = 0;
        if(n == 1){
            return s;
        }
        while(j < n){                                          //n
            if(!list.contains(s.charAt(j))){
                list.add(s.charAt(j++));//c--j:0;
            }else{
                int length = 0;
                list.add(s.charAt(j));//continue  next  cc --  j=1;
                for(int i = 0;i < list.size();i++){               //m
                    if(list.get(i) == s.charAt(j)){//i:0
                        keyList.clear();
                        length = list.size() - i;
                        if(length> maxNums){
                            keyList.clear();
                            for(int m = i;m < list.size();m++){// 0 2 ++
                                keyList.add(list.get(m)); //cc
                            }
                            if(revers1(keyList)){//2             //p
                                maxNums = keyList.size();
                                str = "";
                                for(char c:keyList){
                                    str = str + c;
                                }

                                break;
                            }
                        }
                    }
                }
                j++;

            }
        }
        return str;
    }

    public static boolean revers1(List list){
        int middle = list.size()/2;
        int i = 0;
        int j = 0;
        if(list.size() % 2 == 0){
            i = middle -1;
            j = middle;
        }else if(list.size() % 2 == 1){
            i = middle - 1;
            j = middle + 1;
        }

        while(i >= 0 && j <= list.size() -1){
            if(list.get(i--) == list.get(j++)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }


    /**
     * 实现方法二
     * @param s
     * @return
     */
    public static String getPailStr2(String s){
        int n = s.length();
        String str = "";
        int maxNums = 0;
        List<Character> list = new ArrayList();
        List<Character> keyList = new ArrayList();
        int j = 0;
        if(n == 1){
            return s;
        }
        while(j < n){
            if(!list.contains(s.charAt(j))){
                list.add(s.charAt(j++));//c--j:0;
            }else{
                int length = 0;
                list.add(s.charAt(j));//continue  next  cc --  j=1;
                for(int i = 0;i < list.size();i++){
                    if(list.get(i) == s.charAt(j)){//i:0
                        keyList.clear();
                        length = list.size() - i;
                        if(length> maxNums){
                            keyList.clear();
                            for(int m = i;m < list.size();m++){// 0 2 ++
                                keyList.add(list.get(m)); //cc
                            }
                            if(revers2(keyList)){//2
                                maxNums = keyList.size();
                                str = "";
                                for(char c:keyList){
                                    str = str + c;
                                }

                                break;
                            }
                        }
                    }
                }
                j++;

            }
        }

        // for(char c:tarList){
        //      str = str + c;
        // }
        return str;
    }

    public static boolean revers2(List list){
        int middle = list.size()/2;
        int i = 0;
        int j = 0;
        if(list.size() % 2 == 0){
            i = middle -1;
            j = middle;
        }else if(list.size() % 2 == 1){
            i = middle - 1;
            j = middle + 1;
        }

        while(i >= 0 && j <= list.size() -1){
            if(list.get(i--) == list.get(j++)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}
