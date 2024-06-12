package hejow.java.practice.algorithm.programmers;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("all")
class 데이터_분석 {
  public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
    return Arrays.stream(data)
      .filter(it -> it[parseKey(ext)] < val_ext)
      .sorted(Comparator.comparingInt(it -> it[parseKey(sort_by)]))
      .toArray(int[][]::new);
  }

  private int parseKey(String input) {
    return switch (input) {
      case "code" -> 0;
      case "date" -> 1;
      case "maximum" -> 2;
      case "remain" -> 3;
      default -> throw new IllegalArgumentException();
    };
  }
}
