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

public class BOJ_1563_개근상 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] lo; // ~A, ~AA, ~*
    static int[][] lx; // ~A, ~AA, ~*
    static final int DIV = 1_000_000;

    public static void main(String[] args) throws IOException {

        int x = Integer.parseInt(br.readLine());

        lo = new int[x+1][3];
        lx = new int[x+1][3];

        lo[1][2] = 1; lx[1][0] = 1; lx[1][2] = 1;


        for(int i=2;i<=x;i++) {

            lo[i][0] = lo[i-1][2];
            lo[i][1] = lo[i-1][0];
            lo[i][2] = (lo[i-1][0] + lo[i-1][1] + lo[i-1][2] + lx[i-1][0] + lx[i-1][1] + lx[i-1][2]) % DIV;

            lx[i][0] = lx[i-1][2];
            lx[i][1] = lx[i-1][0];
            lx[i][2] = (lx[i-1][0] + lx[i-1][1] + lx[i-1][2]) % DIV;
        }

        System.out.println((lx[x][0] + lx[x][1] + lx[x][2] + lo[x][0] + lo[x][1] + lo[x][2]) % DIV);



    }
}