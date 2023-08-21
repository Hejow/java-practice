package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3079 {
    static BufferedReader br = getBufferedReader();
    static int[] taskTables;
    static int maxInput = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = getTokenizer();
        int n = getIntFromToken(st);
        int m = getIntFromToken(st);

        initTableAndMaxInput(n);

        long minTime = calcMinTime(m);
        System.out.println(minTime);
    }

    private static long calcMinTime(int people) {
        long minTime = 0;
        long maxTime = (long) maxInput * people;

        while (minTime <= maxTime) {
            long middleTime = (minTime + maxTime) / 2;
            int passed = countPassedByGivenTime(middleTime);

            if (passed < people) {
                minTime = middleTime + 1;
            } else {
                maxTime = middleTime - 1;
            }
        }

        return minTime;
    }

    private static int countPassedByGivenTime(long givenTime) {
        int passed = 0;

        for (int task : taskTables) {
            passed += givenTime / task;
        }

        return passed;
    }

    private static void initTableAndMaxInput(int n) throws IOException {
        taskTables = new int[n];

        for (int i = 0 ; i < n ; i++) {
            taskTables[i] = getIntFromInput();
            maxInput = Math.max(maxInput, taskTables[i]);
        }
    }

    private static int getIntFromToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    private static int getIntFromInput() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static StringTokenizer getTokenizer() throws IOException {
        return new StringTokenizer(br.readLine());
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
