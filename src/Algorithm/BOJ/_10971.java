package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _10971 {
    private static final String BLANK = " ";
    private static final int START = 0;
    static BufferedReader br = newBufferedReader();
    static int[][] graph;
    static boolean[] visited;
    static int n;
    static int cost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        initInput();
        backTracking(1, START, 0);
        System.out.println(cost);
    }

    private static void backTracking(int count, int start, int tmpCost) {
        if (count == n && isLinked(start, START)) {
            cost = Math.min(cost, tmpCost + graph[start][START]);
            return;
        }

        for (int i = 1 ; i < n ; i++) {
            if (isNotVisitable(start, i)) continue;
            visited[i] = true;
            backTracking(count + 1, i, tmpCost + graph[start][i]);
            visited[i] = false;
        }
    }

    private static boolean isNotVisitable(int start, int destination) {
        return visited[destination] || start == destination || !isLinked(start, destination);
    }

    private static boolean isLinked(int start, int destination) {
        return graph[start][destination] != 0;
    }

    private static void initInput() throws IOException {
        n = readInput();
        visited = new boolean[n];
        graph = new int[n][];

        for (int i = 0 ; i < n ; i ++) {
            graph[i] = readInputsAsArray();
        }
    }

    private static int[] readInputsAsArray() throws IOException {
        String inputs = br.readLine();
        return Arrays.stream(inputs.split(BLANK))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int readInput() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static BufferedReader newBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
