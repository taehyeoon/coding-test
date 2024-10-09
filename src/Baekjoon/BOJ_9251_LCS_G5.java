package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-30
종료 시간 : 24-03-30
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_9251_LCS_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        String a = br.readLine();
        String b = br.readLine();

        int cntMax = 0;
        for(int i = 0; i < a.length(); i++){

            int ptrA = i;
            int ptrB = 0;
            int cnt = 0;
            while(ptrA < a.length()){
                if(a.charAt(ptrA) == b.charAt(ptrB)){
                    cnt++;
                    ptrA++;
                }
                ptrB++;
            }

            cntMax = Math.max(cnt, cntMax);
        }

        System.out.println(cntMax);




    }
}