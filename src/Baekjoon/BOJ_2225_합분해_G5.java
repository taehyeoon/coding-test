package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-07 11:20
종료 시간 : 24-04-07 11:53
실행 시간 : 108ms
메 모 리 : 12184KB
*/

public class BOJ_2225_합분해_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long[][] dp;
    static final int MOD = 1_000_000_000;

    private static long getDP(int n, int k){
        if(dp[n][k] == 0){
            long sum = 0;
            for (int i = 0; i <= n; i++) {
                sum += getDP(n-i, k-1);
                sum %= MOD;
            }
            dp[n][k] = sum;
        }

        return dp[n][k];
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new long[N+1][K+1];
        for (int i = 0; i <= N; i++) {
            dp[i][1] = 1;
        }

        System.out.println(getDP(N, K));
    }
}