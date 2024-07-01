package hejow.java.practice.algorithm.programmers;

@SuppressWarnings("all")
class 콜라_문제 {
  public int solution(int a, int b, int n) {
    int answer = 0;

    int remain = n;

    while (true) {
      int q = remain / a;

      if (q == 0) {
        break;
      }

      int coke = q * b;
      
      answer += coke;
      remain = remain - q * a + coke;
    }

    return answer;
  }
}
