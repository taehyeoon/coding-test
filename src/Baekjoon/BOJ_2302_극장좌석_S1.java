package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-21 20:30
종료 시간 : 24-03-21 21:03
실행 시간 : 80ms
메 모 리 : 11512KB
*/

public class BOJ_2302_극장좌석_S1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static boolean[] vips;

    private static void input() throws IOException{
        N = Integer.parseInt(br.readLine());

        int vipNum = Integer.parseInt(br.readLine());

        vips = new boolean[N+1];
        for (int i = 0; i < vipNum; i++) {
            int vip = Integer.parseInt(br.readLine());
            vips[vip] = true;
        }
    }

    public static void main(String[] args) throws IOException {

        input();

        if(N == 1){
            System.out.println(1);
            return;
        }else if(N==2){
            System.out.println(2);
            return;
        }

        List<Integer> nonVipGroup = new ArrayList<>();

        int cnt = 0;
        int maxGroup = 0;
        for (int i = 1; i <= N; i++) {
            if(vips[i]){
                if(cnt != 0) {
                    nonVipGroup.add(cnt);
                    maxGroup = Math.max(maxGroup, cnt);
                }
                cnt = 0;
            }
            else cnt++;
        }

        if(cnt != 0) nonVipGroup.add(cnt);
        int[] dp = new int[N+1];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int result = 1;
        for(int num : nonVipGroup){
            result *= dp[num];
        }

        System.out.println(result);
    }
}