package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1439 {
    static BufferedReader br = getBufferedReader();

    public static void main(String[] args) throws IOException {
        String input = readInput();
        int count = calcCount(input);
        System.out.println(count);
    }

    private static int calcCount(String input) {
        int count = 0;
        char standard = input.charAt(0);

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                continue;
            } else if (input.charAt(i) != standard) {
                count++;
            }
        }

        return count;
    }

    private static String readInput() throws IOException {
        return br.readLine().trim();
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
