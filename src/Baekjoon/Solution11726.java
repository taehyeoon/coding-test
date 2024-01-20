package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 2xn타일링 11726 S3
시작 시간 : 24-01-20 16:00
종료 시간 : 24-01-20 16:08
실행시간 : 76ms

고려사항
 */

public class Solution11726 {

    static int[] memo = new int[10001];
    static final int divider = 10007;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        System.out.println(dp(n) % divider);
    }

    private static int dp(int x) {
        if(x == 1) return 1;
        if(x == 2) return 2;

        if(memo[x] == 0)
            memo[x] = dp(x-1) + dp(x-2);

        return memo[x] % 10007;
    }
}