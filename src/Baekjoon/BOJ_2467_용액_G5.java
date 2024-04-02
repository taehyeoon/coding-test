package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-04-01 21:15
종료 시간 : 24-04-01 21:43
실행 시간 : 276ms / 실패
메 모 리 : 31868KB
*/

public class BOJ_2467_용액_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] data;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        data = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = N-1;
        int ans = Integer.MAX_VALUE;
        int lVal = 0, rVal = 0;
        while (l<r){
            int val = data[l] + data[r];
            if(Math.abs(val) < ans){
                ans = Math.abs(val);
                lVal = data[l];
                rVal = data[r];
            }

            if(val > 0) r--;
            else if(val < 0) l++;
            else{
                lVal = data[l];
                rVal = data[r];
                break;
            }
        }

        System.out.println(lVal + " " + rVal);
    }
}