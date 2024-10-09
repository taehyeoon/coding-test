package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1943_동전분해 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] coins;

    public static void main(String[] args) throws IOException {

        for (int iter = 0; iter < 3; iter++) {
            N = Integer.parseInt(br.readLine());
            int sum = 0;

            coins = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int coin = coins[i][0] = Integer.parseInt(st.nextToken());
                int cnt = coins[i][1] = Integer.parseInt(st.nextToken());
                sum += coin*cnt;
            }

            if((sum & 1) != 0)
                System.out.println("0");
            else
                System.out.println(solve(sum/2));
        }

    }

    private static int solve(int mid) {
        int[][] dp = new int[N+1][mid+1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        for (int i = 0; i < N; i++) {
            int[] coin = coins[i];

            for (int j = 0; j <= mid; j++) {
                if(dp[i][j] == Integer.MAX_VALUE) continue;
                if(j + coin[0] <= mid && dp[i][j] < coin[1]){
                    dp[i][j+coin[0]] = Math.min(dp[i][j+coin[0]], dp[i][j]+1);
                }
                dp[i+1][j] = 0;
            }
        }

        return dp[N][mid] == 0 ? 1 : 0;
    }

}