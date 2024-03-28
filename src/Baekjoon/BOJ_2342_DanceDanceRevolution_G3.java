package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-29
종료 시간 : 24-03-29
실행 시간 : 512ms / 실패
메 모 리 : 55792KB
*/

public class BOJ_2342_DanceDanceRevolution_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] cmds;
    static int[][][] dp;

    private static void input() throws IOException{
        String str = br.readLine();
        st = new StringTokenizer(str);
        N = str.length() / 2;
        cmds = new int[N];
        for (int i = 0; i < N; i++) {
            cmds[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1][5][5]; // 0번째 초기 step~N번째, 왼쪽발 5가지 , 오른쪽 5가지 경우
    }

    private static int getScore(int from, int to){
        if(from == to) return 1;
        if(from == 0) return 2;
        if(Math.abs(from-to) == 2) return 4;
        return 3;
    }

    private static int dfs(int step, int l, int r){

        if(step == N) return 0;

        if(dp[step][l][r] != 0) return dp[step][l][r];

        int lMoveScore = getScore(l, cmds[step]) + dfs(step+1, cmds[step], r);
        int rMoveScore = getScore(r, cmds[step]) + dfs(step+1, l, cmds[step]);

        return dp[step][l][r] = Math.min(lMoveScore, rMoveScore);
    }
    public static void main(String[] args) throws IOException {

        input();

        System.out.println(dfs(0,0,0));

    }
}