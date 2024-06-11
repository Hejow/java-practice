package hejow.java.practice.algorithm.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

@SuppressWarnings("all")
class 붕대_감기 {
  public static int solution(int[] bandage, int health, int[][] attacks) {
    var onProcess = 0;
    var result = health;
    var duration = attacks[attacks.length - 1][0];

    Queue<int[]> attackTimes = new ArrayDeque<>();
    for (int[] attack : attacks) {
      attackTimes.add(attack);
    }

    for (int time = 1; time < duration; time++) {
      if (attackTimes.peek()[0] == time) {
        result -= attackTimes.poll()[1];

        if (result <= 0) {
          return -1;
        }

        onProcess = 0;
        continue;
      }

      result = result + bandage[1];
      onProcess++;

      if (onProcess == bandage[0]) {
        result += bandage[2];
        onProcess = 0;
      }

      result = Math.min(result, health);
    }

    if (!attackTimes.isEmpty()) {
      result = result - attackTimes.poll()[1];
    }

    return result > 0 ? result : -1;
  }
}
