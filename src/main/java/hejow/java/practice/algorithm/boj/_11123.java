package hejow.java.practice.algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11123 {
    private static final char SHEEP = '#';
    private static final int DIRECTIONS = 4;
    private static final int X = 0;
    private static final int Y = 1;
    static BufferedReader br = newBufferedReader();
    static BufferedWriter bw = newBufferedWriter();
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static StringTokenizer st;
    static int h, w, result;
    static char[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        run();
    }

    private static void run() throws IOException {
        int t = readInput();
        for (int i = 0; i < t; i++) {
            initStatic();
            countSheep();
            writeResult();
        }
        flushResults();
    }

    private static void flushResults() throws IOException {
        bw.flush();
    }

    private static void writeResult() throws IOException {
        bw.write(result + "\n");
    }

    private static void countSheep() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;
                bfs(i, j);
            }
        }
    }

    private static void bfs(int x, int y) {
        if (board[x][y] != SHEEP) return;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] currentPoint = q.poll();

            for (int i = 0; i < DIRECTIONS; i++) {
                int nx = currentPoint[X] + dx[i];
                int ny = currentPoint[Y] + dy[i];

                if (isNotOutBoundary(nx, ny) && !visited[nx][ny] && isSheep(nx, ny)) {
                    int[] newPoint = new int[]{nx, ny};
                    q.add(newPoint);
                    visited[nx][ny] = true;
                }
            }
        }

        result++;
    }

    private static boolean isSheep(int nx, int ny) {
        return board[nx][ny] == SHEEP;
    }

    private static boolean isNotOutBoundary(int nx, int ny) {
        return 0 <= nx && nx < h && 0 <= ny && ny < w;
    }

    private static void initStatic() throws IOException {
        result = 0;
        st = newTokenizer();
        h = getIntFromToken(st);
        w = getIntFromToken(st);

        visited = new boolean[h][w];
        board = new char[h][];
        for (int i = 0; i < h; i++) {
            board[i] = readInputsAsArray();
        }
    }

    private static char[] readInputsAsArray() throws IOException {
        return br.readLine().toCharArray();
    }

    private static int getIntFromToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    private static int readInput() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static StringTokenizer newTokenizer() throws IOException {
        return new StringTokenizer(br.readLine());
    }

    private static BufferedWriter newBufferedWriter() {
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static BufferedReader newBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
