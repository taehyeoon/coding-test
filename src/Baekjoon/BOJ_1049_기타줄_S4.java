package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
시작 시간 : 24-03-07 21:50
종료 시간 : 24-03-07 22:12
실행 시간 : 76ms
메 모 리 : 11572KB
*/

public class BOJ_1049_기타줄_S4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int minSix = Integer.MAX_VALUE;
        int minOne = Integer.MAX_VALUE;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int six = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            minSix = Math.min(minSix, six);
            minOne = Math.min(minOne, one);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= N/6; i++) {
            int price = minSix * i +  minOne * (N-i*6);
            ans = Math.min(ans, price);
        }
        if(N%6 != 0) ans = Math.min(ans, minSix * (N/6 + 1));

        System.out.println(ans);
    }
}

