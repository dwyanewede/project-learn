package com.learn.demo.concurrent.xiaomage.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: LinkedTransferQueueQuestion
 * @Description: LinkedTransferQueue 与 LinkedBlockingQueue 相比有直接存取的优势
 *               与 SynchronousQueue 相比有队列存取优势
 * @Author: 尚先生
 * @CreateDate: 2019/4/18 8:40
 * @Version: 1.0
 */
public class LinkedTransferQueueQuestion {

//     1. transfer(E e)：若当前存在一个正在等待获取的消费者线程，即立刻移交之；否则，会插入当前元素e到队列尾部，并且等待进入阻塞状态，到有消费者线程取走该元素。
//     2. tryTransfer(E e)：若当前存在一个正在等待获取的消费者线程（使用take()或者poll()函数），使用该方法会即刻转移/传输对象元素e；若不存在，则返回false，并且不进入队列。这是一个不阻塞的操作。
//     3. tryTransfer(E e, long timeout, TimeUnit unit)：若当前存在一个正在等待获取的消费者线程，会立即传输给它;否则将插入元素e到队列尾部，并且等待被消费者线程获取消费掉；若在指定的时间内元素e无法被消费者线程获取，则返回false，同时该元素被移除。
//     4. hasWaitingConsumer()：判断是否存在消费者线程。
//     5. getWaitingConsumerCount()：获取所有等待获取元素的消费线程数量。
//     6. size()：因为队列的异步特性，检测当前队列的元素个数需要逐一迭代，可能会得到一个不太准确的结果，尤其是在遍历时有可能队列发生更改。
//     7. 批量操作：类似于addAll，removeAll, retainAll, containsAll, equals, toArray等方法，API不能保证一定会立刻执行。因此，我们在使用过程中，不能有所期待，这是一个具有异步特性的队列。


    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<Integer> transferQueue = new LinkedTransferQueue<>();
        transferQueue.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));
        System.out.println(" size: " +transferQueue.size());
//        transferQueue.transfer(20);

        new Thread(() -> {
            try {
                System.out.println("transferQueue.take() " + transferQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        // TODO 测试 transfer 和 tryTransfer 等相关实现 需要注释掉
        // 若当前存在一个正在等待获取的消费者线程，即立刻移交之 该实现会直接移交元素 66
//         transferQueue.transfer(66);

        // 若当前存在一个正在等待获取的消费者线程（使用take()或者poll()函数），使用该方法会即刻转移/传输对象元素e
//         transferQueue.tryTransfer(77);
         // 若当前存在一个正在等待获取的消费者线程，会立即传输给它 该实现会直接移交元素 88
//        transferQueue.tryTransfer(88,1,TimeUnit.SECONDS);

        System.out.println(" tryTransfer size: " +transferQueue.size());
        transferQueue.forEach(con -> System.out.println(con));
    }

}
