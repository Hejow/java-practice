package hejow.java.practice.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여러분의_다리가_되어_드리겠습니다_17352 {
    static BufferedReader br = bufferedReader();
    static StringTokenizer st;
    static int[] parent;
    static int n;

    public static void main(String[] args) throws IOException {
        n = readInput();
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n - 2; i++) {
            st = stringTokenizer();
            int start = nextToken(st);
            int end = nextToken(st);
            union(start, end);
        }

        for (int i = 2; i <= n; i++) {
            if (isNotSameParent(1, i)) {
                System.out.print(1 + " " + i);
                return;
            }
        }
    }

    private static boolean isNotSameParent(int x, int y) {
        return find(x) != find(y);
    }

    private static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        parent[y] = x;
    }

    private static int nextToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    private static StringTokenizer stringTokenizer() throws IOException {
        return new StringTokenizer(br.readLine());
    }

    private static int readInput() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static BufferedReader bufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
