package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-28 23:25
종료 시간 : 24-02-28 23:59
실행 시간 : 100ms
메 모 리 : 12036KB
*/

public class BOJ_11055_가장큰증가하는부분수열_S2 {

    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++){
            dp[i] = arr[i];
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]) {
                    int sum = dp[j] + arr[i];
                    dp[i] = Math.max(dp[i], sum);
                }
            }
            if(dp[i] > ans) ans = dp[i];
        }
        System.out.println(ans);
    }
}