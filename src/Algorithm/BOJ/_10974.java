package Algorithm.BOJ;

import java.io.*;

public class _10974 {
    static BufferedReader br = newBufferedReader();
    static BufferedWriter bw = newBufferedWriter();
    static boolean[] visited;
    static int[] result;
    static int n;

    public static void main(String[] args) throws IOException {
        initStatic();
        backTracking(0);
    }

    private static void initStatic() throws IOException {
        n = readInput();
        visited = new boolean[n];
        result = new int[n];
    }

    private static void backTracking(int count) throws IOException {
        if (count == n) {
            print();
            return;
        }

        for (int i = 0 ; i < n ; i++) {
            if (visited[i]) continue;
            result[count] =  i + 1;
            visited[i] = true;
            backTracking(count + 1);
            visited[i] = false;
            result[count] = 0;
        }
    }

    private static void print() throws IOException {
        for (int i = 0 ; i < n ; i++) {
            bw.write(result[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }

    private static int readInput() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static BufferedWriter newBufferedWriter() {
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static BufferedReader newBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
