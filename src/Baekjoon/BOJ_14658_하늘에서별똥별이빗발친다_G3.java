package Baekjoon;

import java.io.*;
import java.security.Key;
import java.util.*;



/*
시작 시간 : 24-06-13
종료 시간 : 24-06-13
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_14658_하늘에서별똥별이빗발친다_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] stars;
    static int N, M, L, K;
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stars = new int[K][];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars[i] = new int[]{x,y};
        }

        int ans = K;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                ans = Math.min(ans, K - findStar(stars[i][0], stars[j][1]));
            }
        }
        System.out.println(ans);
    }

    private static int findStar(int x, int y){
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            if(x <= stars[i][0] && stars[i][0] <= x+L
                    && y <= stars[i][1] && stars[i][1] <= y+L){
                cnt++;
            }
        }
        return cnt;
    }
}