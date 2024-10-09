package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1477_휴게소세우기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, L;
    static int[] rest;
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        rest = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            rest[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(rest);

        int lo = 0, hi = L;
        while(lo + 1 < hi){

            int mid = (lo + hi) / 2;

            int cnt = 0, curPos = 0;
            for(int i = 0; i < N; i++){
                cnt += (rest[i] - curPos-1) / mid;
                curPos = rest[i];
            }
            cnt += (L-curPos-1) / mid;

            if(cnt <= M){
                hi = mid;
            }else{
                lo = mid;
            }
        }

        System.out.println(hi);
    }
}