package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _13904 {
    static class Task {
        int deadline;
        int point;

        public Task(int deadline, int point) {
            this.deadline = deadline;
            this.point = point;
        }
    }
    static BufferedReader br = getBufferedReader();
    static List<Task> tasks = new ArrayList<>();
    static StringTokenizer st;
    static int maxDeadline = 0;

    public static void main(String[] args) throws IOException {
        initStatic();
        int maxPoint = doHomework();
        System.out.println(maxPoint);
    }

    private static int doHomework() {
        int sum = 0;

        for (int i = maxDeadline ; i >= 1 ; i--) {
            Task task = new Task(0, 0);
            for (Task currentTask : tasks) {
                if (currentTask.deadline >= i && task.point < currentTask.point) {
                    task = currentTask;
                }
            }
            sum += task.point;
            tasks.remove(task);
        }

        return sum;
    }

    private static void initStatic() throws IOException {
        int n = readInput();

        for (int i = 0 ; i < n ; i++) {
            st = getTokenizer();

            int deadline = nextToken(st);
            int point = nextToken(st);
            tasks.add(new Task(deadline, point));

            maxDeadline = Math.max(maxDeadline, deadline);
        }
    }

    private static int nextToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    private static int readInput() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static StringTokenizer getTokenizer() throws IOException {
        return new StringTokenizer(br.readLine());
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}