package hejow.java.practice.algorithm.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

@SuppressWarnings("all")
class 개인정보_수집_유효기간 {
  private static final int MONTH = 28;
  private static final int SKIP = -1;

  public int[] solution(String today, String[] terms, String[] privacies) {
    var todayDate = parseDate(today);

    Map<String, Integer> termTable = Arrays.stream(terms)
      .collect(HashMap::new,
        (map, term) -> {
          var split = term.split(" ");
          map.put(split[0], Integer.parseInt(split[1]) * MONTH);
        },
        HashMap::putAll);

    return IntStream.range(0, privacies.length)
      .map(index -> {
        var split = privacies[index].split(" ");

        var signedAt = parseDate(split[0]);
        var duration = termTable.get(split[1]);

        return todayDate > signedAt + duration - 1 ? index + 1 : SKIP;
      })
      .filter(it -> it != SKIP)
      .toArray();
  }

  private int parseDate(String date) {
    var split = Arrays.stream(date.split("\\."))
      .mapToInt(Integer::parseInt)
      .toArray();

    return split[0] * 12 * MONTH + split[1] * MONTH + split[2];
  }
}
