package com.learn.demo.design.spring.pattern.structural.adapter.quque;

/**
 * @ClassName: IQueue
 * @Description: 自定义数组实现队列
 * @Author: 尚先生
 * @CreateDate: 2019/4/10 11:15
 * @Version: 1.0
 */
public interface IQueue<E> {
    //  add offer
    boolean add(E e) throws Exception;
    public void clear();
    //  remove poll
    E remove() throws Exception;

    public E peek() throws Exception;

    public boolean isEmpty();
}
