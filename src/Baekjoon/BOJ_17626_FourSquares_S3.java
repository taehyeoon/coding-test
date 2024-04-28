package Baekjoon;

import java.io.*;

/*
시작 시간 : 24-04-28 22:00
종료 시간 : 24-04-28 22:40
실행 시간 : 104ms
메 모 리 : 11888KB
*/

public class BOJ_17626_FourSquares_S3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static Integer[] dp = new Integer[50_001];

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;

        int min = 0;
        for (int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;

            for (int j = 1; j*j <= i; j++) {
                int temp = i - j*j;
                min = Math.min(min, dp[temp]);
            }

            dp[i] = min+1;
        }
        System.out.println(dp[N]);
    }
}