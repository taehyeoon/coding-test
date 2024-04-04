package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-30 20:10
종료 시간 : 24-03-30 20:35
실행 시간 : 120ms
메 모 리 : 13044KB
*/

public class BOJ_2512_예산_S2 {

    static int N, total, maxRequest;
    static int[] request;
    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        request = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            request[i] = Integer.parseInt(st.nextToken());
            maxRequest = Math.max(maxRequest, request[i]);
        }
        total = Integer.parseInt(br.readLine());
    }

    private static int getTotal(int upper){

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if(request[i] > upper) sum += upper;
            else sum += request[i];
        }

        return sum;
    }
    public static void main(String[] args) throws IOException {

        input();

        int lo = 0;
        int hi = maxRequest+1;

        while (lo + 1 < hi){

            int mid = (lo + hi) / 2;

            if(getTotal(mid) <= total) lo = mid;
            else hi = mid;
        }

        System.out.println(lo);
    }
}