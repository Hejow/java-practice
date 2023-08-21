package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11000 {
    static class Lecture {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public static Lecture of(StringTokenizer st) {
            return new Lecture(nextToken(st), nextToken(st));
        }
    }

    static BufferedReader br = getBufferedReader();
    static StringTokenizer st;
    static Lecture[] lectures;

    public static void main(String[] args) throws IOException {
        int t = readInput();
        initInputs(t);
        int count = calcCount(t);
        System.out.println(count);
    }

    private static int calcCount(int t) {
        Queue<Integer> endTimes = new PriorityQueue<>();
        endTimes.offer(lectures[0].end);

        for (int i = 1 ; i < t ; i++) {
            Lecture nextLecture = lectures[i];
            if (endTimes.peek() <= nextLecture.start) {
                endTimes.poll();
            }
            endTimes.offer(nextLecture.end);
        }

        return endTimes.size();
    }

    private static void initInputs(int t) throws IOException {
        lectures = new Lecture[t];

        for (int i = 0 ; i < t ; i++) { // O(n)
            st = getTokenizer();
            lectures[i] = Lecture.of(st);
        }

        Arrays.sort(lectures, (l1, l2) -> compare(l1, l2));
    }

    private static int compare(Lecture a, Lecture b) {
        return a.start == b.start ? a.end - b.end : a.start - b.start;
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
