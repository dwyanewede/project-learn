package com.learn.demo.java8.reconstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentDataHandlerFrame {

  public static void main(String[] args) {
    List<Integer> allData = getAllData(getKeys(), new GetTradeData());
    System.out.println(allData);
  }

  public static List<String> getKeys() {
    List<String> keys = new ArrayList<String>();
    for (int i=0; i< 20000; i++) {
      keys.add(String.valueOf(i));
    }
    return keys;
  }

  /**
   * 获取所有业务数据
   */
  public static <T> List<T> getAllData(List<String> allKeys, final IGetBizData iGetBizData) {
    List<String> parts = TaskUtil.divide(allKeys.size(), 1000);
    System.out.println(parts);
    ExecutorService executor = Executors.newFixedThreadPool(parts.size());
    CompletionService<List<T>>
        completionService = new ExecutorCompletionService<List<T>>(executor);
    for (String part: parts) {
      int start = Integer.parseInt(part.split(":")[0]);
      int end = Integer.parseInt(part.split(":")[1]);
      if (end > allKeys.size()) {
        end = allKeys.size();
      }
      final List<String> tmpRowkeyList = allKeys.subList(start, end);
      completionService.submit(new Callable<List<T>>() {
        public List<T> call() throws Exception {
          System.out.println("submit() 当前执行线程为： " + Thread.currentThread().getName());
          return iGetBizData.getData(tmpRowkeyList);
        }
      });
    }

    List<T> result = new ArrayList<T>();
    for (int i=0; i< parts.size(); i++) {
      try {
        result.addAll(completionService.take().get());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    executor.shutdown();
    return result;
  }

}

/** 业务数据接口 */
interface IGetBizData<T> {
  List<T> getData(List<String> keys);
}

/** 获取业务数据具体实现 */
class GetTradeData implements IGetBizData<Integer> {

  public List<Integer> getData(List<String> keys) {
    // maybe xxxService.getData(keys);
    List<Integer> result = new ArrayList<Integer>();
    System.err.println("getData() 当前执行线程为： " + Thread.currentThread().getName());
//    try {
//      TimeUnit.MILLISECONDS.sleep(1);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
    for (String key: keys) {
      result.add(Integer.valueOf(key) % 1000000000);
    }
    return result;
  }

}