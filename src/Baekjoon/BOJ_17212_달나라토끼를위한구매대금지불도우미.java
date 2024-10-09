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

public class BOJ_17212_달나라토끼를위한구매대금지불도우미 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int cost;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        cost = Integer.parseInt(br.readLine());
        dp = new int[100_001];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 1;
        dp[6] = 2;
        dp[7] = 1;

        for (int i = 8; i <= cost ; i++) {
            dp[i] = Math.min(dp[i-1], Math.min(dp[i-2], Math.min(dp[i-5], dp[i-7]))) +1;
        }
        System.out.println(dp[cost]);

    }

}