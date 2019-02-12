package com.learn.demo.design.pattern;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: ChainDemo
 * @Description: 链式接口
 * @Author: 尚先生
 * @CreateDate: 2018/12/18 14:58
 * @Version: 1.0
 */
public class ChainDemo {

    public static void main(String[] args) {
        DefaultExecutorChain executorChain = new DefaultExecutorChain();
        executorChain.addExecutor(new Executor() {
            @Override
            public void execute(ExecutorChain chain) {
                System.out.println(" hello world 0 ");
                executorChain.execute();
            }
        });
        executorChain.addExecutor(new Executor() {
            @Override
            public void execute(ExecutorChain chain) {
                System.out.println(" hello world 1 ");
                executorChain.execute();
            }
        });
        executorChain.addExecutor((ch) ->{
            System.out.println(" hello world 2 ");
            ch.execute();
        });
        executorChain.addExecutor((ch) ->{
            System.out.println(" hello world 3 ");
        });
        executorChain.execute();
    }

    public static class DefaultExecutorChain implements ExecutorChain {
        private final List<Executor> executorList = new LinkedList<>();
        private int position = 0;
        public void addExecutor(Executor executor) {
            executorList.add(executor);
        }

        @Override
        public void execute() {
            int pos = position;
            Executor executor = executorList.get(pos);
            System.out.println("执行第 " + pos + " 个Executor元素");
            position++;
            executor.execute(this);
        }
    }

    public interface Executor {
        void execute(ExecutorChain chain);
    }

    public interface ExecutorChain {
        void execute();
    }
}
