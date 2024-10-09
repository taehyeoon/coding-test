package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-19 22:20
종료 시간 : 24-03-19
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_2293_동전1_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[] coin;
    static int[] dp;
    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coin = new int[N];
        dp = new int[K+1];
    }

    private static int solve(int x){

        if(x < 0) return 0;
        if(dp[x] == 0){
            int sum = 0;

            sum += solve(x-1);
            sum += solve(x-2);
            sum += solve(x-5);

            dp[x] = sum;
        }

        return dp[x];
    }

    public static void main(String[] args) throws IOException {

        input();

        dp[0] = 1;

        System.out.println(solve(K));
    }
}