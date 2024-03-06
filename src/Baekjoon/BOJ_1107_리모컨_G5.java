package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-01 16:00
종료 시간 : 24-03-06 19:30
실행 시간 : 264ms / 실패
메 모 리 : 66852KB
*/

public class BOJ_1107_리모컨_G5 {

    static int Number, ans = Integer.MAX_VALUE;
    static boolean[] broken = new boolean[10];


    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Number = Integer.parseInt(br.readLine());

        int brokenNum = Integer.parseInt(br.readLine());
        if(brokenNum != 0){

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < brokenNum; i++) {
                int val = Integer.parseInt(st.nextToken());
                broken[val] = true;
            }
        }
    }

    private static void solve(int x){
        int originX = x;
        while (x >= 10){
            if(broken[x%10]) return;
            x /= 10;
        }
        if(broken[x]) return;

        ans = Math.min(ans, Math.abs(originX - Number) + String.valueOf(originX).length());
    }
    public static void main(String[] args) throws IOException {

        input();

        if(Number == 100){
            System.out.println(0);
            return;
        }

        ans = Math.abs(Number - 100);
        for(int i = 0; i <= 1_000_000; i++){
            solve(i);
        }


        System.out.println(ans);
    }
}