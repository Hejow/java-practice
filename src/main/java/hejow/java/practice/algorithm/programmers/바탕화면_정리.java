package hejow.java.practice.algorithm.programmers;

@SuppressWarnings("all")
class 바탕화면_정리 {
  private static final char FILE = '#';

  public int[] solution(String[] wallpaper) {
    int luy = Integer.MAX_VALUE;
    int lux = Integer.MAX_VALUE;

    int rdx = 0;
    int rdy = 0;

    for (int y = 0; y < wallpaper.length; y++) {
      for (int x = 0; x < wallpaper[0].length(); x++) {
        if (wallpaper[y].charAt(x) == FILE) {
          luy = Math.min(luy, y);
          lux = Math.min(lux, x);

          rdy = Math.max(rdy, y + 1);
          rdx = Math.max(rdx, x + 1);
        }
      }
    }

    return new int[]{luy, lux, rdy, rdx};
  }
}
