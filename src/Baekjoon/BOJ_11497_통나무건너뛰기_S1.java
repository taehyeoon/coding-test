package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-22 23:10
종료 시간 : 24-05-22 04:07
실행 시간 : 416ms
메 모 리 : 48584KB
*/

public class BOJ_11497_통나무건너뛰기_S1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {

            int N = Integer.parseInt(br.readLine());
            int[] data = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(data);

            int a = 0, b = 0;
            int big, small;
            int ans = 0, i;
            if(N % 2 == 1){
                big = Math.max(data[N-2], data[N-3]);
                small = Math.min(data[N-2], data[N-3]);
                ans = Math.max(data[N-1] - big, data[N-1] - small);
                i = N-4;
            }else{
                big = data[N-1];
                small = data[N-2];
                ans = big - small;
                i = N-3;
            }

            for (; i >= 1; i-=2) {
                a = data[i];
                b = data[i-1];

                if(b > a) {
                    int temp = a;
                    a = b;
                    b = temp;
                }

                ans = Math.max(ans, Math.max(big - a, small - b));
                big = a;
                small = b;
            }
            ans = Math.max(ans, Math.abs(a-b));
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}