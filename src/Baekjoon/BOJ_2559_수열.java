package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_2559_수열 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[] temper;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        temper = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            temper[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < K; i++) {
            sum += temper[i];
        }

        long ans = sum;
        for (int i = 0; i < N-K; i++) {

            sum -= temper[i];
            sum += temper[i+K];
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}