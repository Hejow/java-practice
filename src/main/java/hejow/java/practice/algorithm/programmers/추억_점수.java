package hejow.java.practice.algorithm.programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

@SuppressWarnings("all")
class 추억_점수 {
  public int[] solution(String[] name, int[] yearning, String[][] photo) {
    var names = Arrays.stream(name).collect(Collectors.toList()); // 프로그래머스가 toList()를 지원하지 않음

    return Arrays.stream(photo)
      .mapToInt(it -> Arrays.stream(it)
        .mapToInt(i -> names.indexOf(i) < 0 ? 0 : yearning[names.indexOf(i)])
        .sum())
      .toArray();
  }
}
