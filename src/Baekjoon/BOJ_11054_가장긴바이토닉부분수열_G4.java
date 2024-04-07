package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-07 12:10
종료 시간 : 24-04-07 15:35
실행 시간 : 144ms / 실패
메 모 리 : 19708KB
*/

public class BOJ_11054_가장긴바이토닉부분수열_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] data;
    static Integer[] dpArc, dpDesc;

    private static int LIS(int n){

        if(dpArc[n] == null){
            dpArc[n] = 1;

            for (int i = n-1; i >= 0; i--) {
                if(data[i] < data[n]) {
                    dpArc[n] = Math.max(dpArc[n], LIS(i)+1);
                }
            }
        }

        return dpArc[n];
    }

    private static int LDS(int n){

        if(dpDesc[n] == null){
            dpDesc[n] = 1;

            for (int i = n+1; i < N; i++) {
                if(data[i] < data[n]) {
                    dpDesc[n] = Math.max(dpDesc[n], LDS(i)+1);
                }
            }
        }

        return dpDesc[n];
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        dpArc = new Integer[N];
        dpDesc = new Integer[N];
        for (int i = 0; i < N; i++) {
            LIS(i);
            LDS(i);
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            max = Math.max(dpArc[i] + dpDesc[i], max);
        }

        System.out.println(max-1);
    }
}