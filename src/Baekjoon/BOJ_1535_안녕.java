package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-10-12
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1535_안녕 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] health, hi;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        health = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        hi = new int[N+1];
        for (int i = 1; i <= N; i++) {
            hi[i] = Integer.parseInt(st.nextToken());
        }

        // i번째 사람까지 고려했을 때, j만큼의 체력을 썼을 떄의 기쁨
        dp = new int[N+1][100];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 100; j++) {

                if(j >= health[i]) dp[i][j] = Math.max(dp[i-1][j-health[i]] + hi[i], dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[N][99]);
    }
}