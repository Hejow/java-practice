package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2295 {
    static BufferedReader br = getBufferedReader();
    static int n;
    static int[] numbers;
    static List<Integer> sums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int gap = numbers[i] - numbers[j];
                if (binarySearch(gap)) {
                    System.out.println(numbers[i]);
                    return;
                }
            }
        }
    }

    private static boolean binarySearch(int target) {
        int left = 0;
        int right = sums.size() - 1;
        int middle;

        while (left < right) {
            middle = (left + right) / 2;
            if (target > sums.get(middle)) {
                left = middle + 1;
            } else if (target < sums.get(middle)) {
                right = middle - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    private static void init() throws IOException {
        n = readInput();
        numbers = new int[n];

        for (int i = 0 ; i < n ; i++) {
            numbers[i] = readInput();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sums.add(numbers[i] + numbers[j]);
            }
        }

        Arrays.sort(numbers);
        Collections.sort(sums);
    }

    private static int readInput() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
