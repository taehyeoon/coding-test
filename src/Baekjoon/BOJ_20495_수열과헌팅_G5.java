package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_20495_수열과헌팅_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        int[] left = new int[N];
        int[] right = new int[N];
        int[] originalLift = new int[N];
        int[] originalRight = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int delta = Integer.parseInt(st.nextToken());

            left[i] = a-delta;
            originalLift[i] = left[i];
            right[i] = a+delta;
            originalRight[i] = right[i];

        }

        Arrays.sort(left);
        Arrays.sort(right);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {

            // find minimum
            int min = lowerBound(right, originalLift[i]);
            sb.append(min+1).append(" ");


            // find maximum
            int max = upperBound(left, originalRight[i]);
            sb.append(max+1).append("\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }

    private static int upperBound(int[] arr, int val) {

        int lo = -1;
        int hi = arr.length;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= val) {
                lo = mid;
            }else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int lowerBound(int[] arr, int val) {

        int lo = -1;
        int hi = arr.length;

        while (lo + 1 < hi) {

            int mid = (lo + hi) / 2;

            if (arr[mid] >= val) {
                hi = mid;
            }else {
                lo = mid;
            }
        }
        return hi;
    }
}

