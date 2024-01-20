package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 RGB거리 1149 S1
시작 시간 : 24-01-20 16:12
종료 시간 : 24-01-20 16:40
실행시간 : 88ms

고려사항
1번 집부터 n번 집까지 탐색
현재 k번째의 R집을 색칠한다고 할 때
k번째 R집까지 칠하는 최소값 = min(k-1번째 G집 + k-1번째 B집)
 */

public class Solution1149 {

    static int[][] data;
    static int[][] memo = new int[1001][3];
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        data = new int[n+1][3];

        //  input
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
            data[i][2] = Integer.parseInt(st.nextToken());
        }

        memo[1][0] = data[1][0];
        memo[1][1] = data[1][1];
        memo[1][2] = data[1][2];

        int minVal = Math.min(dp(n,0), Math.min(dp(n,1), dp(n,2)));
        System.out.println(minVal);
    }

    private static int dp(int x, int idx) {

        if(memo[x][idx] == 0){
            if(idx == 0)      memo[x][idx] = Math.min(dp(x-1,1), dp(x-1,2)) + data[x][idx];
            else if(idx == 1) memo[x][idx] = Math.min(dp(x-1,0), dp(x-1,2)) + data[x][idx];
            else if(idx == 2) memo[x][idx] = Math.min(dp(x-1,0), dp(x-1,1)) + data[x][idx];
        }

        return memo[x][idx];
    }
}