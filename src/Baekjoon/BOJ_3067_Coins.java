package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_3067_Coins {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < TC; tc++) {
            int result = sol();
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static int sol() throws IOException {
        N = Integer.parseInt(br.readLine());
        coins = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());

        dp = new int[target+1];

        int ans = getDp(target);

        for (int i = 0; i <= target; i++) {
            System.out.println(i + " : " + dp[i]);
        }
        return ans;
    }

    static int[] dp, coins;
    static int N;

    private static int getDp(int x){

        System.out.println("getDp called : " + x);
        if(x <= 0) return 0;
        if(dp[x]!=0) return dp[x];

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += getDp(x-coins[i]);
            if(x == coins[i]) sum++;
        }



        return dp[x] = sum;
    }
}