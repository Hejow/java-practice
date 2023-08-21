package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class _2012 {
    static BufferedReader br = getBufferedReader();
    static Integer[] inputs;
    static long answer = 0; //

    public static void main(String[] args) throws IOException {
        int n = readInputAsInt();
        inputs = readInputs(n);
        solution(n);
        System.out.println(answer);
    }

    private static void solution(int n) {
        Arrays.sort(inputs);
        IntStream.rangeClosed(0, n-1)
                .forEach(_2012::sumDissatisfaction);
    }

    private static void sumDissatisfaction(int i) {
        answer += Math.abs(inputs[i] - (i + 1));
    }

    private static Integer[] readInputs(int n) throws IOException {
        Integer[] result = new Integer[n];

        for (int i = 0; i < n; i++) {
            result[i] = readInputAsInt();
        }

        return result;
    }

    private static Integer readInputAsInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
