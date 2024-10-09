package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-23
종료 시간 : 24-04-23
실행 시간 : 80ms / 실패
메 모 리 : 11880KB
*/

public class BOJ_1256_사전_G2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static long[][] dp = new long[202][202];

    public static void main(String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= 200; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i = 0; i <= 200; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];

                if(dp[i][j] > 1_000_000_000)
                    dp[i][j] = 1_000_000_001;
            }
        }

        if(dp[M+N][M] < K){
            System.out.println(-1);
            return;
        }

        while (!(N==0 && M == 0)){
            if(dp[M+N-1][M] >= K){
                sb.append("a");
                N--;
            }else{
                sb.append("z");
                K -= dp[M+N-1][M];
                M--;
            }
        }

        System.out.println(sb);
    }
}