package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-30 17:00
종료 시간 : 24-03-30 18:20
실행 시간 : 336ms
메 모 리 : 35228KB
*/

public class BOJ_2792_보석상자_S1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] jewel;

    private static int requiredPerson(int x){

        int p = 0;

        for (int i = 0; i < M; i++) {
            if(jewel[i] % x == 0) p += jewel[i] / x;
            else                  p += jewel[i] / x + 1;
        }

        return p;
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        jewel = new int[M];
        int maxJewel = 0;
        for (int i = 0; i < M; i++) {
            jewel[i] = Integer.parseInt(br.readLine());
            maxJewel = Math.max(maxJewel, jewel[i]);
        }

        int l = 0;
        int h = maxJewel+1;
        while (l+1 < h){
            int mid = (l+h)/2;
            // mid 만큼의 질투심이 N명의 사람으로 가능한가?
            if(requiredPerson(mid) <= N) h = mid;
            else l = mid;
        }

        System.out.println(h);
    }
}