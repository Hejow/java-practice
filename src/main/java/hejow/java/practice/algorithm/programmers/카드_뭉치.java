package hejow.java.practice.algorithm.programmers;

@SuppressWarnings("all")
class 카드_뭉치 {
  public String solution(String[] cards1, String[] cards2, String[] goal) {
    var card1 = 0;
    var card2 = 0;

    for (String s : goal) {
      if (card1 < cards1.length && cards1[card1].equals(s)) {
        card1++;
      } else if (card2 < cards2.length && cards2[card2].equals(s)) {
        card2++;
      } else {
        return "No";
      }
    }

    return "Yes";
  }

  public static void main(String[] args) {
    var tmp = new 카드_뭉치();
    tmp.solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"});
  }
}
