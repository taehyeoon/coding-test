package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-20 01:20
종료 시간 : 24-05-20 01:43
실행 시간 : 352ms
메 모 리 : 27828KB
*/

public class BOJ_2230_수고르기_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] data;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        Arrays.sort(data);
        int l = 0, r = 1;

        int val = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        while (r<N){

            val = data[r] - data[l];

            if (r == N-1 && val < M) break;

            if(val < M){
                r++;
            }else if (val > M){
                if(l+1 == r){
                    l++; r++;
                }else{
                    l++;
                }
                ans = Math.min(ans, val);
            }else {
                System.out.println(M);
                return;
            }
        }

        System.out.println(ans);
    }
}