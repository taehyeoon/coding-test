package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-17 20:40
종료 시간 : 24-02-17
실행시간 : 136ms / 실패
메 모 리 : 14944KB
*/

public class BOJ_1654_랜선자르기_S2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int K, N;
    static long ans;
    static long min = 1, max = Long.MIN_VALUE;
    static long[] lines;

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lines = new long[K];

        for (int i = 0; i < K; i++) {
            lines[i] = Long.parseLong(br.readLine());
            max = Math.max(max, lines[i]);
        }
    }

    private static void solve(){
        long cnt, half;

        while(min <= max){
            half = (min+max) / 2;
            cnt = 0;
            for(long line : lines)
                cnt += line / half;

            if(cnt < N){
                max = half-1;
            }else{
                min = half+1;
            }

        }

        ans = (min+max) / 2;
    }
    public static void main(String[] args) throws IOException {
        input();
        solve();

        System.out.println(ans);
    }
}
