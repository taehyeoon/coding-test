package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-26
종료 시간 : 24-03-26
실행 시간 : 100ms / 실패
메 모 리 : 15660KB
*/

public class BOJ_2482_색상환_G3 {

    static int N, K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][N+1];
        for(int i = 1; i <= N-1; i++){
            dp[i][0] = 1;
            dp[i][1] = i;
        }
        dp[3][2] = 1;

        for(int n = 4; n <= N-1; n++){
            for(int k = 2; k <= K; k++){
                dp[n][k] = (dp[n-2][k-1] + dp[n-1][k]) % 1_000_000_003;
            }
        }

        System.out.println((dp[N-3][K-1] + dp[N-1][K]) % 1_000_000_003);
    }
}
