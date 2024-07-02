package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1823_수확_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] V;
    static int[][] memo;
    private static int solve(int a, int b, int order){

        if(memo[a][b] != 0) return memo[a][b];

        if(a == b) return memo[a][b] = order * V[a];

        int lChoose = solve(a+1, b, order+1) + order*V[a];
        int rChoose = solve(a, b-1, order+1) + order*V[b];

        return memo[a][b] = Math.max(lChoose, rChoose);
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        V = new int[N+1];
        memo = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            V[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solve(1,N,1));
    }
}