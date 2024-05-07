package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-07 17:00
종료 시간 : 24-05-07 20:14
실행 시간 : 708ms / 실패
메 모 리 : 12472KB
*/

public class BOJ_20366_같이눈사람만들래_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] snow;
    static int[] choose;
    static int ans = Integer.MAX_VALUE;
    private static void findOther(){

        int base = snow[choose[1]] + snow[choose[0]];
        int l = 0, r = N-1;

        while(l < r){
            if(l == choose[0] || l == choose[1]) l++;
            else if(r == choose[0] || r == choose[1]) r--;
            else{
                int second = snow[r] + snow[l];
                if(second > base){
                    ans = Math.min(ans, second - base);
                    r--;
                }else if(second < base){
                    ans = Math.min(ans, base - second);

                    l++;
                }else{
                    ans = 0;
                    return;
                }
            }
        }
    }
    private static void per(int cnt, int start){
        if(cnt == 2){
            findOther();
            return;
        }

        for (int i = start; i < N; i++) {
            choose[cnt] = i;
            per(cnt+1, i+1);
        }
    }
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        snow = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snow[i] = Integer.parseInt(st.nextToken());
        }
        choose = new int[2];

        Arrays.sort(snow);

        per(0, 0);

        System.out.println(ans);

    }
}