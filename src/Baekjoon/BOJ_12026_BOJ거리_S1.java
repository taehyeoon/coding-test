package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
시작 시간 : 24-03-31 21:00
종료 시간 : 24-03-31 21:34
실행 시간 : 100ms
메 모 리 : 12164KB
*/

public class BOJ_12026_BOJ거리_S1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static char[] data;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        dp = new Integer[N];
        dp[0] = 0;
        data = br.readLine().toCharArray();
        for (int i = 1; i < N; i++) {
            int  min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {

                if(data[i] == 'O'){
                    if(data[j] == 'B' && dp[j] != null){
                        min = Math.min(min, dp[j] + (int)Math.pow(i-j,2));
                    }
                }else if(data[i] == 'J'){
                    if(data[j] == 'O' && dp[j] != null){
                        min = Math.min(min, dp[j] + (int)Math.pow(i-j,2));
                    }
                }else if(data[i] == 'B'){
                    if(data[j] == 'J' && dp[j] != null){
                        min = Math.min(min, dp[j] + (int)Math.pow(i-j,2));
                    }
                }
            }

            if(min != Integer.MAX_VALUE) dp[i] = min;
        }

        if(dp[N-1] == null) System.out.println(-1);
        else System.out.println(dp[N-1]);
    }
}