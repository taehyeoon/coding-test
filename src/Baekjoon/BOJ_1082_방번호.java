package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-10-14
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1082_방번호 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] rooms;
    static String[] dp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        rooms = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            rooms[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());

        dp = new String[M+1];

        for (int i = 0; i < N; i++) {
            if(rooms[i] <= M) dp[rooms[i]] = String.valueOf(i);
        }

        System.out.printf("%d", '0');
        System.out.printf("%d", '-');
        // String result = getDP(M);
        // System.out.println(result);
    }

    private static String getDP(int x) {

        if(x < 0) return "";
        if(dp[x] != null) return dp[x];

        String result = "";
        for (int i = 0; i < N; i++) {

            int cost = rooms[i];

            String a = Integer.toString(i).concat(getDP(x-cost));
            String b = getDP(x-cost).concat(Integer.toString(i));

            System.out.println("a = " + a);
            System.out.println("b = " + b);
            String biggest = a.compareTo(b) > 0 ? a : b;

            result = result.compareTo(biggest) > 0 ? result : biggest;
        }

        return dp[x] = result;
    }
}