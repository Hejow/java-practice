package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _24444 {
    public static final int NOT_VISITED = 0;
    static BufferedReader br = newBufferedReader();
    static StringTokenizer st;
    static int u, v, r;
    static int[] visit;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        initInputs();
        bfs();
        print();
    }

    private static void print() {
        for (int i = 1 ; i < u + 1 ; i ++) {
            System.out.println(visit[i]);
        }
    }

    private static void bfs() {
        Queue<List<Integer>> queue = new LinkedList<>();
        int sequence = 1;
        queue.add(graph.get(r));

        while (!queue.isEmpty()) {
            List<Integer> nodes = queue.poll();
            for (var node : nodes) {
                if (visit[node] == NOT_VISITED) {
                    visit[node] = ++sequence;
                    queue.add(graph.get(node));
                }
            }
        }
    }

    private static void initInputs() throws IOException {
        st = newTokenizer();
        u = getIntFromToken(st);
        v = getIntFromToken(st);
        r = getIntFromToken(st);
        visit = new int[u + 1];
        visit[r] = 1;

        for (int i = 0 ; i < u + 1 ; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0 ; i < v ; i++) {
            st = newTokenizer();
            putNode(st);
        }

        for (var nodes : graph) {
            Collections.sort(nodes);
        }
    }

    private static void putNode(StringTokenizer st) {
        int start = getIntFromToken(st);
        int end = getIntFromToken(st);

        graph.get(start).add(end);
        graph.get(end).add(start);
    }

    private static int getIntFromToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    private static StringTokenizer newTokenizer() throws IOException {
        return new StringTokenizer(br.readLine());
    }

    private static BufferedReader newBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
