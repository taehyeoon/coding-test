package Baekjoon;

import java.io.*;

/*
시작 시간 : 24-04-05 00:10
종료 시간 : 24-04-05 01:00
실행 시간 : 80ms
메 모 리 : 11428KB
*/

public class BOJ_3687_성냥개비_G2 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        String[][] dp = new String[101][2];

        dp[2][0] = "1";   dp[2][1] = "1";
        dp[3][0] = "7";   dp[3][1] = "7";
        dp[4][0] = "4";
        dp[5][0] = "2";
        dp[6][0] = "6";
        dp[7][0] = "8";
        dp[8][0] = "10";
        dp[9][0] = "18";
        dp[10][0] = "22";
        dp[11][0] = "20";

        // 최소
        dp[17][0] = "200";
        for (int i = 12; i <= 100; i++) {
            if(i == 17) continue;
            dp[i][0] = dp[i-7][0] + "8";
        }

        // 최대
        for (int i = 4; i <= 100; i++) {
            dp[i][1] = dp[i-2][1] + "1";
        }

        for (int tc = 0; tc < TC; tc++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(dp[x][0]).append(" ");
            sb.append(dp[x][1]).append("\n");
        }

        System.out.println(sb);

    }
}