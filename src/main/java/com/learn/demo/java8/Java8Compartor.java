package com.learn.demo.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName: Java8Compartor
 * @Description: Compartor Lambda 表达式
 * @Author: 尚先生
 * @CreateDate: 2019/5/6 11:02
 * @Version: 1.0
 */
public class Java8Compartor {

    public static void main(String[] args) {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

        // 1.1 使用匿名内部类根据 name 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });
        String remark = "使用匿名内部类根据 name 排序 players ";
        print(players,remark);

        // 1.2 使用 lambda expression 排序 players
        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(players, sortByName);
        remark = "使用 lambda expression 排序 players ";
        print(players,remark);

        // 1.3 也可以采用如下形式:
        Arrays.sort(players, (
                String s1, String
                s2) -> (s1.compareTo(s2)));
        remark = "也可以采用如下形式: ";
        print(players,remark);

        //其他的排序如下所示。和上面的示例一样, 代码分别通过匿名内部类和一些lambda表达式来实现Comparator :
        // 1.1 使用匿名内部类根据 surname 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
            }
        });
        remark = "使用匿名内部类根据 surname 排序 players ";
        print(players,remark);

        // 1.2 使用 lambda expression 排序,根据 surname
        Comparator<String> sortBySurname = (String s1, String s2) ->
                (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
        Arrays.sort(players, sortBySurname);
        remark = "使用 lambda expression 排序,根据 surname ";
        print(players,remark);

        // 1.3 或者这样,怀疑原作者是不是想错了,括号好多...
        Arrays.sort(players, (
                String s1, String
                s2) ->
                (s1.substring(s1.indexOf(" ")).

                        compareTo(s2.substring(s2.indexOf(" "))))
        );
        remark = "或者这样,怀疑原作者是不是想错了,括号好多... ";
        print(players,remark);

        // 2.1 使用匿名内部类根据 name lenght 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.length() - s2.length());
            }
        });
        remark = "使用匿名内部类根据 name lenght 排序 players ";
        print(players,remark);

        // 2.2 使用 lambda expression 排序,根据 name lenght
        Comparator<String> sortByNameLenght = (String s1, String s2) -> (s1.length() - s2.length());
        Arrays.sort(players, sortByNameLenght);
        remark = "使用 lambda expression 排序,根据 name lenght ";
        print(players,remark);

        // 2.3 or this
        Arrays.sort(players, (
                String s1, String
                s2) -> (s1.length() - s2.length()));
        remark = "2.3 or this ";
        print(players,remark);

        // 3.1 使用匿名内部类排序 players, 根据最后一个字母
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
            }
        });
        remark = "使用匿名内部类排序 players, 根据最后一个字母 ";
        print(players,remark);

        // 3.2 使用 lambda expression 排序,根据最后一个字母
        Comparator<String> sortByLastLetter =
                (String s1, String s2) ->
                        (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
        Arrays.sort(players, sortByLastLetter);
        remark = "使用 lambda expression 排序,根据最后一个字母 ";
        print(players,remark);

        // 3.3 or this
        Arrays.sort(players, (
                String s1, String
                s2) -> (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1)));
        remark = "3.3 or this ";
        print(players,remark);

        // 4.1 Comparator
        Stream<String> sorted = Arrays.asList(players).stream().sorted(String::compareTo);

        sorted.forEach(con -> System.out.println("Comparator 后 " + con));
    }


    private static void print(String[] players,String remark){
        // 排序上述方法
        Arrays.asList(players).forEach(con -> System.out.println(remark + con));
    }
}