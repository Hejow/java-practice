package hejow.java.practice.algorithm.programmers;

@SuppressWarnings("all")
class 덧칠하기 {
  public int solution(int n, int m, int[] section) {
    int answer = 0;

    var index = 0;

    for (; index < section.length; ) {
      var now = section[index++];

      for (int i = index; i < section.length; i++) {
        if (section[i] - now >= m) {
          index = i;
          break;
        } else {
          index++;
        }
      }

      answer++;
    }

    return answer;
  }
}
