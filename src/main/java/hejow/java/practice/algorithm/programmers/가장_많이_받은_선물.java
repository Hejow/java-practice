package hejow.java.practice.algorithm.programmers;

import java.util.Arrays;
import java.util.HashMap;

@SuppressWarnings("all")
class 가장_많이_받은_선물 {
  public static int solution(String[] friends, String[] gifts) {
    var length = friends.length;

    var table = new HashMap<String, Integer>();
    for (var i = 0 ; i < length ; i++) {
      table.put(friends[i], i);
    }

    var giftRate = new int[length];
    var giveAndTakes = new int[length][length];

    for (var gift : gifts) {
      var splits = gift.split(" ");

      var giver = table.get(splits[0]);
      var reciever = table.get(splits[1]);

      giveAndTakes[giver][reciever]++;

      giftRate[giver]++;
      giftRate[reciever]--;
    }

    var result = new int[length];

    for (int i = 0; i < length - 1; i++) {
      for (int j = i + 1; j < length; j++) {
        var giver = table.get(friends[i]);
        var reciever = table.get(friends[j]);

        if (giveAndTakes[giver][reciever] > giveAndTakes[reciever][giver]) {
          result[giver]++;
        } else if (giveAndTakes[giver][reciever] == giveAndTakes[reciever][giver]) {
          if (giftRate[giver] > giftRate[reciever]) {
            result[giver]++;
          } else if (giftRate[giver] < giftRate[reciever]) {
            result[reciever]++;
          }
        } else {
          result[reciever]++;
        }
      }
    }

    return Arrays.stream(result).max().orElse(0);
  }
}
