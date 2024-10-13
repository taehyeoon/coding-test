package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-10-13
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1106_호텔 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int C, N;
    static int[] cost, people;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        cost = new int[N];
        people = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cost[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[1101];

        Arrays.fill(dp, 987654321);

        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            dp[people[i]] = cost[i];
        }

        for (int i = 0; i < N; i++) {
            for (int j = people[i]; j < C+101; j++) {
                if(dp[j-people[i]] != 987654321) {
                    dp[j] = Math.min(dp[j], dp[j-people[i]] + cost[i]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = C; i < 1101; i++) {
            ans = Math.min(ans, dp[i]);
        }
        System.out.println(ans);
    }
}