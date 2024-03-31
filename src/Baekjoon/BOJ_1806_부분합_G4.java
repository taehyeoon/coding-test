package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-27
종료 시간 : 24-03-31
실행 시간 : 232ms
메 모 리 : 22512KB
*/

public class BOJ_1806_부분합_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, S;
    static int[] data;

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        data = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        int l = 0;
        int r = 0;
        int sum = data[0];
        int ans = Integer.MAX_VALUE;
        while (l<N){
            if(sum >= S){
                ans = Math.min(ans, r-l+1);
                sum -= data[l];
                l++;
            }else{
                if(r == N-1) break;
                r++;
                sum += data[r];
            }
        }
        if(ans == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(ans);
    }
}