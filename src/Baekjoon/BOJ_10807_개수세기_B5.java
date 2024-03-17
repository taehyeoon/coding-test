package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-17 15:20
종료 시간 : 24-03-17 15:24
실행 시간 : 80ms
메 모 리 : 11572KB
*/

public class BOJ_10807_개수세기_B5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int t = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i] == t) cnt++;
        }

        System.out.println(cnt);
    }
}