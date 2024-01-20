package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 계단오르기 2579 S3
시작 시간 : 24-01-20 17:00
종료 시간 : 24-01-20 18:45
실행시간 : 76ms
정답 참조

고려사항
1,2,3 번째 계단은 예외처리
(3칸전까지의 최대 + 1칸전의 값) 과 (2칸전까지의 최대)
두 값중 큰 값을 재귀적으로 선택
 */

public class Solution2579 {

    static int[] data;
    static int[] dp;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        data = new int[n + 1];
        dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            data[i] = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        }
        dp[1] = data[1];
        for (int i = 2; i <= n; i++) {

            if(i == 2) dp[2] = data[1] + data[2];
            else if(i == 3) dp[3] = Math.max(data[1], data[2]) + data[3];
            else dp[i] = Math.max(dp[i-2], dp[i-3] + data[i-1]) + data[i];
        }

        System.out.println(dp[n]);
    }
}