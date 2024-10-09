package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-05-26 01:33
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_3273_두수의합_S3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, X;
    static int[] data;

    private static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        data = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());
    }
    public static void main(String[] args) throws IOException {

        input();
        Arrays.sort(data);

        if(N == 1){
            System.out.println(0);
            return;
        }

        int l = 0, r = N-1;
        int cnt = 0;
        while (l < r){

            int sum = data[l] + data[r];

            if(sum < X)l++;
            else if(sum > X) r--;
            else{
                cnt++;

            }

        }

        System.out.println(cnt);
    }
}