package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-18 20:20
종료 시간 : 24-04-18 21:50
실행 시간 : 228ms / 실패
메 모 리 : 17928KB
*/

public class BOJ_2643_색종이올려놓기_G4 {

    static int N;
    static int[][] squares;

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        squares = new int[N][];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(h >= w)  squares[i] = new int[]{h, w};
            else squares[i] = new int[]{w,h};
        }
    }

    public static void main(String[] args) throws IOException {

        input();

        Arrays.sort(squares, ((o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1]-o2[1];
            else return o1[0] - o2[0];
        }));

        int ans = 1;
        int[] dp = new int[N];

        Arrays.fill(dp, 1); // i번째 종이는 무조건 포함

        for (int i = N-1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                int k = i - j;
                if (squares[k][1] <= squares[i][1]
                    || squares[k][1] <= squares[i][0] && squares[k][0] <= squares[i][1]){
                    dp[k] = Math.max(dp[k], dp[i]+1);
                    ans = Math.max(ans, dp[k]);
                }

            }
        }



        System.out.println(ans);
    }
}