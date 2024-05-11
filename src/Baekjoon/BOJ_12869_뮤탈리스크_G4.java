package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-11 18:00
종료 시간 : 24-05-11 19:30
실행 시간 : 88ms
메 모 리 : 14676KB
*/

public class BOJ_12869_뮤탈리스크_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] deltas = {{-9,-3,-1},{-9,-1,-3},{-3,-9,-1},{-3,-1,-9},{-1,-9,-3},{-1,-3,-9}};
    static int[][][] dp;
    static int ans = Integer.MAX_VALUE;


    private static void dfs(int[] hp, int cnt) {
        int h1 = hp[0];
        int h2 = hp[1];
        int h3 = hp[2];

        if(cnt >= ans) return;

        if(dp[h1][h2][h3] != 0 && dp[h1][h2][h3] <= cnt) return;

        dp[h1][h2][h3] = cnt;

        if(h1 == 0 && h2 == 0 && h3 == 0){
            ans = Math.min(ans, cnt);
            return;
        }

        for (int i = 0; i < 6; i++) {
            dfs(new int[] {Math.max(h1 + deltas[i][0], 0),Math.max(h2 + deltas[i][1], 0),Math.max(h3 + deltas[i][2], 0)}, cnt+1);
        }
    }
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] hp = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[61][61][61];

        dfs(hp, 0);

        System.out.println(ans);
    }
}