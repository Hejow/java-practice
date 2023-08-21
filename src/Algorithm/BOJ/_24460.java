package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _24460 {
    private static final int MIN_RANGE = 2;
    private static final int DIVISION_SIZE = 4;
    static final BufferedReader br = getBufferedReader();
    static int[][] seats;

    public static void main(String[] args) throws IOException {
        final int n = readInput();
        initSeats(n);
        int seat = selectSeat(n, 0, 0);
        System.out.println(seat);
    }

    private static int selectSeat(int size, int x, int y) {
        if (size < MIN_RANGE) {
            return seats[x][y];
        }

        final int half = size / 2;
        int[] tmp = new int[DIVISION_SIZE];

        for (int i = 0; i < DIVISION_SIZE; i++) {
            int nx = x + (i % 2) * half; // 0, 1, 0, 1
            int ny = y + (i / 2) * half; // 0, 0, 1, 1

            tmp[i] = selectSeat(half, nx, ny);
        }

        Arrays.sort(tmp);
        return tmp[1];
    }

    private static void initSeats(int n) throws IOException {
        seats = new int[n][n];

        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = newTokenizer();
            for (int j = 0 ; j < n ; j++) {
                seats[i][j] = getNextToken(st);
            }
        }
    }

    private static int getNextToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    private static int readInput() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static StringTokenizer newTokenizer() throws IOException {
        return new StringTokenizer(br.readLine());
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
