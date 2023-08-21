package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14916 {
    private static final int START_INDEX = 2;
    private static final int MAX_VALUE = 100000;
    static BufferedReader br = getBufferedReader();
    static int[] DP;

    public static void main(String[] args) throws IOException {
        int price = readInput();
        initDP(price + 1);
        printResult(price);
    }

    private static void printResult(int price) {
        System.out.println(DP[price] >= MAX_VALUE ? -1 : DP[price]);
    }
    
    private static void initDP(int size) {
        DP = new int[size];
        DP[0] = 0;
        DP[1] = MAX_VALUE;

        for (int i = START_INDEX ; i < size; i++) {
            DP[i] = calcChange(i);
        }
    }

    private static int calcChange(int i) {
        if (i < 5) {
            return DP[i - 2] + 1;
        }
        return Math.min(DP[i - 5], DP[i - 2]) + 1;
    }
    
    private static int readInput() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
