package com.learn.demo.java.base.trycatchfinally;

/**
 * finally语句在return语句执行之后return返回之前执行的
 */
public class FinallyTest1 {

    public static void main(String[] args) {
        
        System.out.println(test1());
    }

    public static int test1() {
        int b = 20;

        try {
            System.out.println("try block");

            return b += 80; 
        }
        catch (Exception e) {

            System.out.println("catch block");
        }
        finally {
            
            System.out.println("finally block");
            
            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
        }
        
        return b;
    }
    
}