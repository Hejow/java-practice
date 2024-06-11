package hejow.java.practice.algorithm.boj;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class _11931 {
    static BufferedReader br = getBufferedReader();
    static BufferedWriter bw = getBufferedWriter();
    static Integer[] inputs;

    public static void main(String[] args) throws IOException {
        int n = readInputAsInt();
        inputs = readInputs(n);

        Arrays.sort(inputs, Collections.reverseOrder());
        writeDown(inputs);
    }

    /** Dual Pivot Quick Sort Algorithm */
    /*private static void dualPivotQuickSort(int left, int right) {
        if (left < right) {
            if (arr[left] < arr[right]) {
                swap(left, right);
            }

            int pivot1 = arr[left];
            int pivot2 = arr[right];

            int lt = left + 1;
            int gt = right - 1;
            int i = lt;

            while (i <= gt) {
                if (arr[i] > pivot1) {
                    swap(i, lt++);
                } else if (arr[i] <= pivot2) {
                    while (i < gt && arr[gt] < pivot2) {
                        gt--;
                    }
                    swap(i, gt--);
                    if (arr[i] > pivot1) {
                        swap(i, lt++);
                    }
                }
                i++;
            }

            swap(left, --lt);
            swap(right, ++gt);

            dualPivotQuickSort(left, lt - 1);
            dualPivotQuickSort(lt + 1, gt - 1);
            dualPivotQuickSort(gt + 1, right);
        }
    }

    private static void swap(int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    } */

    private static Integer[] readInputs(int n) throws IOException {
        Integer[] result = new Integer[n];

        for (int i = 0; i < n; i++) {
            result[i] = readInputAsInt();
        }

        return result;
    }

    private static void writeDown(Integer[] inputs) throws IOException {
        for (int input : inputs) {
            bw.write(input + "\n");
        }
        bw.flush();
    }

    private static Integer readInputAsInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private static BufferedWriter getBufferedWriter() {
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }
}
