package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1099_알수없는문장 {

    static String s;
    static String[] word = new String[50];
    static int[] dp = new int[51];
    static int N, inf = (int) 9e8;

    // 문자열 두 개의 비용을 계산하는 함수
    public static int cost(String a, String b) {
        if (a.length() != b.length()) return inf;

        char[] ta = a.toCharArray();
        char[] tb = b.toCharArray();
        Arrays.sort(ta);
        Arrays.sort(tb);

        if (!Arrays.equals(ta, tb)) return inf;

        int ret = a.length();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) ret--;
        }
        return ret;
    }

    // 주어진 문자열에서 최소 비용을 계산하는 함수
    public static int minCost(String k) {
        int ret = inf;
        for (int i = 0; i < N; i++) {
            ret = Math.min(ret, cost(k, word[i]));
        }
        return ret;
    }

    // DP를 활용해 문제를 해결하는 함수
    public static int sol(int n) {
        if (n == s.length()) return 0;

        if (dp[n] != -1) return dp[n];

        dp[n] = inf;
        for (int i = n; i < s.length(); i++) {
            String k = s.substring(n, i + 1);
            int c = minCost(k);
            if (c == inf) continue;
            dp[n] = Math.min(dp[n], c + sol(i + 1));
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            word[i] = sc.next();
        }

        Arrays.fill(dp, -1);
        int result = sol(0);
        System.out.println(result == inf ? -1 : result);
    }
}