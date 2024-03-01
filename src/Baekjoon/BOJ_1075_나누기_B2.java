package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-01 19:00
종료 시간 : 24-03-01 19:10
실행 시간 : 76ms
메 모 리 : 11528KB
*/

public class BOJ_1075_나누기_B2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N, F;
        String line = br.readLine();
        int base = Integer.parseInt(line.substring(0, line.length()-2));
        F = Integer.parseInt(br.readLine());

        for(int i = 0; i < 100; i++){
            if((base*100 + i) % F == 0){
                if(i < 10){
                    System.out.println("0" + i);
                }else{
                    System.out.println(i);
                }
                return;
            }
        }
    }
}