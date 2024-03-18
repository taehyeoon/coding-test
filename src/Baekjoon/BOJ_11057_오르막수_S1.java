package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-18 00:35
종료 시간 : 24-03-18 00:46
실행 시간 : 80ms
메 모 리 : 11556KB
*/

public class BOJ_11057_오르막수_S1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[10];
        Arrays.fill(dp, 1);

        int iter = 1;
        while(iter < N){

            for (int i = 0; i < 10; i++) {
                for (int j = i+1; j < 10; j++) {
                    dp[i] = (dp[i] + dp[j]) % 10007;
                }
            }
            iter++;
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[i] % 10007;
        }
        System.out.println(sum % 10007);
    }
}