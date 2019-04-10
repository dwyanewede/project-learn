package com.learn.demo.design.spring.pattern.structural.adapter.quque;

/**
 * @ClassName: ArrayQueue
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2019/4/10 11:18
 * @Version: 1.0
 */
public class ArrayQueue<E> implements IQueue<E> {

    private int pos; // 指向队列首个元素

    private E[] array;

    public ArrayQueue(int initialCapacity) {
        if (initialCapacity <= 0)
            // 设置默认队列长度
            array = (E[]) new Object[200];
        else
            array = (E[]) new Object[initialCapacity];
        pos = -1; // 对空
    }

    @Override
    public boolean add(E e) {
        pos++;
        array[pos] = e;
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i <= pos; i++) {
            array[i] = null;
        }
        pos = -1;
    }


    @Override
    public E remove() {
        E x = null;
        try {
            x = peek();
        } catch (Exception e) {
            e.printStackTrace();
        }
        pos--;
        return x;
    }

    @Override
    public E peek() throws Exception {
        E e = null;
        // 返回队列首部第一个元素
        if (array.length > 0){
            e = array[0];
        }
        return e;
    }

    @Override
    public boolean isEmpty() {
        boolean flag = false;
        if (array.length > 0){
            return flag;
        }
        return !flag;
    }

    /**
     * 返回队列的字符串表示
     */
    public String toString() {
        if (isEmpty())
            return "[ ]";

        StringBuffer out = new StringBuffer("[");
        for (int i = 0; i < pos; i++)
            out.append(array[i] + ", ");

        out.append(array[pos] + "]");
        return out.toString();
    }

}
