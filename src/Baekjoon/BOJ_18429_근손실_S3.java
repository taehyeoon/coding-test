package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-24 21:05
종료 시간 : 24-04-24 21:12
실행 시간 : 100ms
메 모 리 : 11784KB
*/

public class BOJ_18429_근손실_S3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[] data;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
    }

    static boolean[] isSelected;
    static int[] result;
    static int ans;
    private static void per(int cnt, int health) {

        if(cnt == N){
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(isSelected[i]) continue;

            isSelected[i] = true;

            if(health-K+data[i] >= 500)
                per(cnt+1, health-K+data[i]);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        isSelected = new boolean[N];
        result = new int[N];

        per(0, 500);

        System.out.println(ans);
    }
}