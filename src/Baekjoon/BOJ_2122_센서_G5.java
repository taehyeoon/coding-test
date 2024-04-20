package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-20 16:30
종료 시간 : 24-04-20 17:00
실행 시간 : 132ms / 실패
메 모 리 : 14828KB
*/

public class BOJ_2122_센서_G5 {

    static int N, K;
    static int[] data;

    static Set<Integer> linked = new HashSet<>();

    private static void input() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        data = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        Arrays.sort(data);

        int[] lengths = new int[N-1];
        for (int i = 0; i < N-1; i++) {
            lengths[i] = data[i+1] - data[i];
        }
        int ans = 0;

        Arrays.sort(lengths);
        for (int i = 0; i < N-K; i++) {
            ans += lengths[i];
        }
        System.out.println(ans);
    }
}