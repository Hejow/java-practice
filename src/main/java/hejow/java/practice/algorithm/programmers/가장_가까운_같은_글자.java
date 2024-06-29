package hejow.java.practice.algorithm.programmers;

import java.util.HashMap;

@SuppressWarnings("all")
class 가장_가까운_같은_글자 {
  public int[] solution(String s) {
    var table = new HashMap<Character, Integer>();

    var answer = new int[s.length()];

    for (int i = 0; i < s.length(); i++) {
      var key = s.charAt(i);
      answer[i] = i - table.getOrDefault(key, i + 1);
      table.put(key, i);
    }

    return answer;
  }
}
