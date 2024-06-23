package hejow.java.practice.algorithm.programmers;

@SuppressWarnings("all")
class 둘만의_암호 {
  public String solution(String s, String skip, int index) {
    var sb = new StringBuilder();

    for (char c : s.toCharArray()) {
      int append = 0;

      for (int i = 1; append < index; i++) {
        var ascii = roll(c + i);
        var next = Character.toString(ascii);

        if (skip.contains(next)) {
          continue;
        }

        if (++append == index) {
          sb.append(next);
        }
      }
    }

    return sb.toString();
  }

  private int roll(int ascii) {
    return ascii > 'z' ? roll(ascii % 'z' + 'a' - 1) : ascii;
  }
}
