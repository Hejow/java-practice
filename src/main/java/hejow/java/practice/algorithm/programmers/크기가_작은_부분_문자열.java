package hejow.java.practice.algorithm.programmers;

@SuppressWarnings("all")
class 크기가_작은_부분_문자열 {
  public int solution(String t, String p) {
    int answer = 0;

    for (int i = 0; i < t.length() - p.length() + 1; i++) {
      if (Long.parseLong(p) >= Long.parseLong(t.substring(i, i + p.length())))
        answer++;
    }

    return answer;
  }

  public static void main(String[] args) {
    var temp = new 크기가_작은_부분_문자열();
    System.out.println(temp.solution("10203", "15"));
  }
}
