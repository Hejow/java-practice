package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14494 {
    private static final int MOD = 1000000007;
    private static final int START = 1;
    static BufferedReader br = newBufferedReader();
    static long[][] board;
    static int n, m;

    public static void main(String[] args) throws IOException {
        init();
        DP();
        System.out.println(board[n][m]);
    }

    private static void DP() {
        for (int x = START ; x <= n ; x++) {
            for (int y = START ; y <= m ; y++) {
                if (x == START && y == START) continue;
                board[x][y] = (board[x-1][y] + board[x][y-1] + board[x-1][y-1]) % MOD;
            }
        }
    }

    private static void init() throws IOException {
        StringTokenizer st = newTokenizer();
        n = getIntFromToken(st);
        m = getIntFromToken(st);

        board = new long[n + 1][m + 1];
        board[1][1] = 1;
    }

    private static int getIntFromToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    private static StringTokenizer newTokenizer() throws IOException {
        return new StringTokenizer(br.readLine());
    }

    private static BufferedReader newBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
