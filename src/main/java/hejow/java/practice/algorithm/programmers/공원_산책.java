package hejow.java.practice.algorithm.programmers;

@SuppressWarnings("all")
class 공원_산책 {
  enum Direction {
    N(0, -1),
    S(0, 1),
    W(-1, 0),
    E(1, 0),
    ;

    final int x;
    final int y;

    Direction(int x, int y) {
      this.y = y;
      this.x = x;
    }
  }

  static class Position {
    private static final char START = 'S';
    private static final char WALL = 'X';

    private final String[] park;

    private int y;
    private int x;

    private Position(String[] park, int y, int x) {
      this.park = park;
      this.y = y;
      this.x = x;
    }

    public static Position init(final String[] park) {
      for (int y = 0; y < park.length; y++) {
        for (int x = 0; x < park[0].length(); x++) {
          if (park[y].charAt(x) == START) {
            return new Position(park, y, x);
          }
        }
      }

      throw new IllegalArgumentException();
    }

    public void move(String route) {
      var split = route.split(" ");

      var direction = Direction.valueOf(split[0]);
      var move = Integer.parseInt(split[1]);

      for (int i = 1; i <= move; i++) {
        var ny = this.y + direction.y * i;
        var nx = this.x + direction.x * i;

        if (ny < 0 || ny >= park.length || nx < 0 || nx >= park[0].length()) {
          return;
        }

        if (park[ny].charAt(nx) == WALL) {
          return;
        }
      }

      this.y += direction.y * move;
      this.x += direction.x * move;
    }

    public int[] now() {
      return new int[]{y, x};
    }
  }

  public int[] solution(String[] park, String[] routes) {
    var position = Position.init(park);

    for (String route : routes) {
      position.move(route);
    }

    return position.now();
  }
}
