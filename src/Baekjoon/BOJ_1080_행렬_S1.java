package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-22 01:20
종료 시간 : 24-05-22 01:43
실행 시간 : 76ms
메 모 리 : 11612KB
*/

public class BOJ_1080_행렬_S1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static boolean[][] a, b;

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                a[i][j] = str.charAt(j) == '1';
            }
        }
        b = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                b[i][j] = str.charAt(j) == '1';
            }
        }
    }
    public static void main(String[] args) throws IOException {

        input();

        int cnt = 0;
        for (int i = 0; i < N-2; i++) {
            for (int j = 0; j < M-2; j++) {
                if(a[i][j] != b[i][j]){
                    cnt++;

                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            a[i+k][j+l] = !a[i+k][j+l];
                        }
                    }
                }
            }
        }

        boolean isEqual = true;
        Find:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] != b[i][j]){
                    isEqual = false;
                    break Find;
                }
            }
        }

        System.out.println(isEqual ? cnt : -1);
    }
}