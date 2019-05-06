package com.learn.demo.java8.reconstruct;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamUtil {

  public static <T,R> List<R> map(List<T> data, Function<T, R> mapFunc) {
    return data.stream().map(mapFunc).collect(Collectors.toList()); // stream replace foreach
  }

}