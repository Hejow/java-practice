package hejow.java.practice.algorithm.programmers;

import java.util.HashMap;

@SuppressWarnings("all")
class 대충_만든_자판 {
  public int[] solution(String[] keymap, String[] targets) {
    int[] answer = new int[targets.length];

    var map = new HashMap<Character, Integer>();

    for (String s : keymap) {
      var chars = s.toCharArray();

      for (int i = 0; i < chars.length; i++) {
        var key = chars[i];
        var value = i + 1;

        map.computeIfPresent(key, (k, v) -> Math.min(v, value));
        map.putIfAbsent(key, value);
      }
    }

    for (int i = 0; i < targets.length; i++) {
      var chars = targets[i].toCharArray();

      int count = 0;
      for (char c : chars) {
        if (!map.containsKey(c)) {
          count = -1;
          break;
        }

        count += map.get(c);
      }

      answer[i] = count;
    }

    return answer;
  }
}
