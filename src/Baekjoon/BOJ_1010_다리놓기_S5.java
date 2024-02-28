package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-02-27 11:15
종료 시간 : 24-02-27 11:30
실행 시간 : 80ms
메 모 리 : 11904KB
*/

public class BOJ_1010_다리놓기_S5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int TC, N, M;
    static long[][] dp = new long[30][30];

    private static long combi(int n, int r){
        if(r == 0 || n == r) return 1;

        if(dp[n][r] == 0){
            dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
        }

        return dp[n][r];
    }

    public static void main(String[] args) throws IOException {

        TC = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < TC; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            sb.append(combi(M, N)).append("\n");
        }


        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
