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

public class BOJ_31778_PPC만들기_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        arr = s.toCharArray();

        int l = 0, r = arr.length - 1;
        while(l < r && K > 0) {

            while(l < N && arr[l] == 'P') l++;
            while(r >= 0 && arr[r] == 'C') r--;

            if(l >= r || l >= N || r < 0) break;

            arr[l] = 'P';
            arr[r] = 'C';
            K--;
        }

        long[] pCnt = new long[N], cCnt = new long[N];
        int p = 0, c = 0;
        for (int i = 0; i < N; i++) {
            pCnt[i] = p;
            if(arr[i] == 'P') {
                p++;
            }
        }
        for (int i = N-1; i >= 0; i--) {
            cCnt[i] = c;
            if(arr[i] == 'C') {
                c++;
            }
        }

        long ans = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i] == 'P') {
                ans += cCnt[i] * pCnt[i];
            }
        }

        System.out.println(ans);
    }
}