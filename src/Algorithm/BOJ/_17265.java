package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17265 {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLY = '*';
    static BufferedReader br = newBufferedReader();
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int n;
    static char operator;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        initStatic();
        solution(1, 1, toInt(board[1][1]));
        System.out.println(max + " " + min);
    }

    private static void solution(int x, int y, int value) {
        if (isDestination(x, y)) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }

        for (int i = 0 ; i < 2 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isInBoundary(nx, ny)) {
                if (isOperator(nx, ny)) {
                    operator = board[nx][ny];
                    solution(nx, ny, value);
                } else {
                    solution(nx, ny, calculate(nx, ny, value));
                    operator = board[x][y];
                }
            }
        }
    }

    private static boolean isOperator(int x, int y) {
        char target = board[x][y];
        return target == PLUS || target == MINUS || target == MULTIPLY;
    }

    private static boolean isInBoundary(int x, int y) {
        return x <= n && y <= n;
    }

    private static int calculate(int x, int y, int value) {
        int result = value;

        switch (operator) {
            case PLUS:
                result += toInt(board[x][y]);
                break;
            case MINUS:
                result -= toInt(board[x][y]);
                break;
            default:
                result *= toInt(board[x][y]);
        }

        return result;
    }

    private static int toInt(char value) {
        return value - '0';
    }

    private static boolean isDestination(int x, int y) {
        return x == n && y == n;
    }

    private static void initStatic() throws IOException {
        n = readInput();

        board = new char[n+1][];
        for (int i = 1 ; i <= n ; i++) {
            board[i] = readInputsAsArray();
        }
    }

    private static char[] readInputsAsArray() throws IOException {
        char[] result = new char[n + 1];
        char[] inputs = br.readLine().replaceAll(" ", "").toCharArray();

        for (int i = 1; i <= n; i++) {
            result[i] = inputs[i - 1];
        }

        return result;
    }

    private static int readInput() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static BufferedReader newBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
