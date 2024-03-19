package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-19 21:50
종료 시간 : 24-03-19 22:05
실행 시간 : 348ms
메 모 리 : 53932KB
*/

public class BOJ_2096_내려가기_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] minList, maxList, map;

    private static void input() throws IOException{
        N = Integer.parseInt(br.readLine());

        minList = new int[N][3];
        maxList = new int[N][3];
        map = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[i] = new int[]{a,b,c};
        }
    }
    public static void main(String[] args) throws IOException {

        input();

        for (int i = 0; i < 3; i++) {
            minList[0][i] = map[0][i];
            maxList[0][i] = map[0][i];
        }

        for (int i = 1; i < N; i++) {
            // min
            minList[i][0] = Math.min(minList[i-1][0], minList[i-1][1]) + map[i][0];
            minList[i][1] = Math.min(minList[i-1][0], Math.min(minList[i-1][1], minList[i-1][2])) + map[i][1];
            minList[i][2] = Math.min(minList[i-1][1], minList[i-1][2]) + map[i][2];

            // max
            maxList[i][0] = Math.max(maxList[i-1][0], maxList[i-1][1]) + map[i][0];
            maxList[i][1] = Math.max(maxList[i-1][0], Math.max(maxList[i-1][1], maxList[i-1][2])) + map[i][1];
            maxList[i][2] = Math.max(maxList[i-1][1], maxList[i-1][2]) + map[i][2];
        }

        int max = Math.max(maxList[N-1][0], Math.max(maxList[N-1][1], maxList[N-1][2]));
        int min = Math.min(minList[N-1][0], Math.min(minList[N-1][1], minList[N-1][2]));

        System.out.print(max + " " + min);
    }
}

