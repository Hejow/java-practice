package hejow.java.practice.algorithm.programmers;

@SuppressWarnings("all")
class 이웃한_칸 {
  public int solution(String[][] board, int h, int w) {
    var dx = new int[]{1, -1, 0, 0};
    var dy = new int[]{0, 0, 1, -1};

    int count = 0;

    for (int i = 0; i < 4; i++) {
      var nx = h + dx[i];
      var ny = w + dy[i];

      if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
        continue;
      }

      count = board[h][w].equals(board[nx][ny]) ? count + 1 : count;
    }

    return count;
  }
}
