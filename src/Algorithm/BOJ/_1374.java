package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1374 {
    static class Lesson implements Comparable<Lesson> {
        private final int start;
        private final int end;

        public Lesson(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public static Lesson from(StringTokenizer st) {
            return new Lesson(nextToken(st), nextToken(st));
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(Lesson o) {
            return this.start - o.getStart();
        }
    }

    static BufferedReader br = getBufferedReader();
    static StringTokenizer st;
    static Queue<Integer> endTimes = new PriorityQueue<>();
    static List<Lesson> lessons = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = readInput();
        initInput(n);
        int rooms = countRooms(n);
        System.out.println(rooms);
    }

    private static int countRooms(int n) {
        int count = 0;

        for (int i = 0 ; i < n ; i++) {
            Lesson nextLesson = lessons.get(i);
            while (isNotEmptyQueue() && isNextStartGE(nextLesson)) {
                endTimes.poll();
            }
            endTimes.add(nextLesson.getEnd());
            count = Math.max(count, endTimes.size());
        }

        return count;
    }

    private static boolean isNextStartGE(Lesson nextLesson) {
        return endTimes.peek() <= nextLesson.getStart();
    }

    private static boolean isNotEmptyQueue() {
        return !endTimes.isEmpty();
    }

    private static void initInput(int n) throws IOException {
        for (int i = 0 ; i < n ; i++) {
            st = getTokenizer();
            nextToken(st);
            lessons.add(Lesson.from(st));
        }

        Collections.sort(lessons);
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
