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

public class BOJ_1398_동전문제_G2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final int[] coin = new int[]{1, 10, 25};

    public static void main(String[] args) throws IOException {

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        // set dp array
        int[] dp = new int[100];

        for (int c = 1; c < dp.length; c++) {
            dp[c] = Integer.MAX_VALUE;

            for (int idx = 0; idx < 3; idx++) {
                if(c - coin[idx] >= 0) {
                    dp[c] = Math.min(dp[c], dp[c-coin[idx]] + 1);
                }
            }
        }

        for (int tc = 0; tc < TC; tc++) {
            long cost = Long.parseLong(br.readLine());

            int coinCnt = 0;

            while(cost > 0) {

                int remain100 = Math.toIntExact(cost % 100);
                coinCnt += dp[remain100];
                cost /= 100;
            }

            sb.append(coinCnt).append("\n");
        }

        System.out.println(sb);
    }
}