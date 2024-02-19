package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-19 23:00
종료 시간 : 24-02-19 23:16
실행 시간 : 76ms
메 모 리 : 11628KB
*/

public class BOJ_1439_뒤집기_S5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String S;

    private static int solve(){
        int toZero = 0;
        boolean beforeZero = true;

        int toOne = 0;
        boolean beforeOne = true;

        for (int i = 0; i < S.length(); i++) {

            if(beforeZero && S.charAt(i) == '0');
            else if(beforeZero && S.charAt(i) == '1') { beforeZero = false; toZero++; }
            else if(!beforeZero && S.charAt(i) == '1');
            else if(!beforeZero && S.charAt(i) == '0') { beforeZero = true; }

            if(beforeOne && S.charAt(i) == '1');
            else if(beforeOne && S.charAt(i) == '0') { beforeOne = false; toOne++; }
            else if(!beforeOne && S.charAt(i) == '0');
            else if(!beforeOne && S.charAt(i) == '1') beforeOne = true;
        }

        return Math.min(toZero, toOne);
    }


    public static void main(String[] args) throws IOException {

        S = br.readLine();
        System.out.println(solve());

        bw.close();
        br.close();
    }
}
