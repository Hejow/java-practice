package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _18222 {
    private static final BufferedReader br = getBufferedReader();

    public static void main(String[] args) throws IOException {
        final long k = readInput();
        int answer = calcAnswer(k);
        System.out.println(answer);
    }

    private static int calcAnswer(long x) {
        if (x == 1) {
            return 0;
        }
        long length = calcLength(x);
        return 1 - calcAnswer(x - length);
    }

    private static long calcLength(long x) {
        long length = 1;

        while (length < x) {
            length *= 2;
        }

        return length / 2;
    }

    private static long readInput() throws IOException {
        return Long.parseLong(br.readLine());
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
