package com.learn.demo.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * @ClassName: TestMonths
 * @Description: 测试三个月份是否连续
 * @Author: 尚先生
 * @CreateDate: 2019/3/28 14:13
 * @Version: 1.0
 */
public class TestMonths {

    // 最近12个月开票记录为0的月份总计不超过三次，并且最近12个月不存在连续三个月开票记录为0
    public static void main(String[] args) {

        // 取当前月份的第一天，往前推12个月
        // 根据月份大小排序，查该公司大于三次直接毙掉，小于三次直接通过，等于三次的月份
        List<String> months = Arrays.asList("2016-12","2017-01","2017-02");
        // 判断给定的排好序的月份是否是相邻的
        System.err.println(judgeMonths(months));

        // 打印相邻两个月份
        List<String> strings = monthAddFrist("2017-01");
        strings.stream().forEach(cousumer -> {
            System.err.println(cousumer);
        });


    }


    /**
     * 判断给定的排好序的月份是否是相邻的
     * @param months
     * @return
     */
    public static boolean judgeMonths(List<String> months) {
        boolean flag = false;
        ArrayList<String> arrayList = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        try {
            Calendar ct = Calendar.getInstance();
            ct.setTime(df.parse(months.get(1)));
            ct.add(Calendar.MONTH, +1);
            String format1 = df.format(ct.getTime());
            ct.add(Calendar.MONTH, -2);
            String format2 = df.format(ct.getTime());
            arrayList.add(format2);
            arrayList.add(format1);
            if (months.get(0).equals(arrayList.get(0)) && months.get(2).equals(arrayList.get(1))){
                flag = true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flag;
    }


    /**
     * 打印相邻两个月份
     * @param date
     * @return
     */
    public static List<String> monthAddFrist(String date) {

        ArrayList<String> arrayList = new ArrayList<>();

        DateFormat df = new SimpleDateFormat("yyyy-MM");
        try {
            Calendar ct = Calendar.getInstance();
            ct.setTime(df.parse(date));
            ct.add(Calendar.MONTH, +1);
            String format1 = df.format(ct.getTime());
            ct.add(Calendar.MONTH, -2);
            String format2 = df.format(ct.getTime());
            arrayList.add(format1);
            arrayList.add(format2);
            return arrayList;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;

    }
}
