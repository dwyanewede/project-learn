package com.learn.demo.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
/**
 * @ClassName: RPN
 * @Description: 逆波兰式（Reverse Polish notation，RPN，或逆波兰记法），
 * 也叫后缀表达式（将运算符写在操作数之后）
 * @Author: 尚先生
 * @CreateDate: 2019/2/27 10:59
 * @Version: 1.0
 */
public class PolishNotation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        StringBuilder sb = new StringBuilder();         //结果
        Stack<Character> opStack = new Stack();         //运算符栈

        Map<Character, Integer> opMap = new HashMap();   //运算符优先级
        opMap.put('(', 0);
        opMap.put('+', 1);
        opMap.put('-', 1);
        opMap.put('*', 2);
        opMap.put('/', 2);

        //处理字符串
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {             //如果是'('直接压栈
                opStack.push('(');
            } else if (isOperator(input.charAt(i))) {  //如果是运算符
                char curOp = input.charAt(i);
                if (opStack.isEmpty())               //如果运算符栈是空，就直接压栈
                    opStack.push(curOp);
                else if (opMap.get(curOp) > opMap.get(opStack.peek()))   //运算符栈不为空，且当当前运算符的优先级比站内第一个运算符的优先级高的时候，压栈
                    opStack.push(curOp);
                else {                               //栈不为空，且运算符的优先级小于等于栈顶元素
                    for (int j = 0; j <= opStack.size(); j++) {
                        char ch = opStack.pop();    //弹出栈内第一个元素
                        sb.append(ch + " ");
                        if (opStack.isEmpty()) {
                            opStack.push(curOp);
                            break;
                        } else if (opMap.get(curOp) > opMap.get(opStack.peek())) {
                            opStack.push(curOp);
                            break;
                        }
                    }
                }
            } else if (input.charAt(i) == ')') {       //如果是')'就把站内'('上的元素都弹出栈
                for (int j = 0; j < opStack.size(); j++) {
                    char c = opStack.pop();
                    if (c == '(')
                        break;
                    else
                        sb.append(c + " ");
                }
            } else {                                  //如果是数字就直接添加
                sb.append(input.charAt(i) + " ");
            }
        }

        //把栈内剩余的运算符都弹出站
        for (int i = 0; i <= opStack.size(); i++) {
            sb.append(opStack.pop() + " ");
        }
        System.out.println(sb);
    }

    private static boolean isOperator(char charAt) {

        if (charAt == '+' || charAt == '-' || charAt == '*' || charAt == '/')
            return true;
        return false;
    }

}