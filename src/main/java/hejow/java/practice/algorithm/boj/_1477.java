package hejow.java.practice.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _1477 {
    static BufferedReader br = getBufferedReader();
    static int n, m, l; // 좋지 않은 선언방식
    static List<Integer> locations;

    public static void main(String[] args) throws IOException {
        initInputs();
        initLocations(n);

        int minDistance = getMinDistance();
        System.out.println(minDistance);
    }

    private static int getBuildableCount(int minDistance) {
        int count = 0;

        for (int i = 1 ; i < locations.size() ; i++) {
            int distance = locations.get(i) - locations.get(i - 1) - 1;
            count += distance / minDistance;
        }

        return count;
    }

    private static int getMinDistance() {
        int start = 1;
        int end = l - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            int buildable = getBuildableCount(middle);

            if (buildable > m) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return start;
    }

    private static void initInputs() throws IOException {
        StringTokenizer st = getTokenizer();
        n = getIntFromToken(st);
        m = getIntFromToken(st);
        l = getIntFromToken(st);
    }

    private static void initLocations(int n) throws IOException {
        locations = new ArrayList<>(List.of(0, l));
        StringTokenizer st = getTokenizer();

        for (int i = 0 ; i < n ; i++) {
            locations.add(getIntFromToken(st));
        }

        Collections.sort(locations);
    }

    private static int getIntFromToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    private static StringTokenizer getTokenizer() throws IOException {
        return new StringTokenizer(br.readLine());
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
