package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-04-16 23:32
종료 시간 : 24-04-16 23:36
실행 시간 : 76ms
메 모 리 : 11440KB
*/

public class BOJ_20499_Darius님한타안함_B4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        String line = br.readLine();
        String[] res = line.split("/");

        int k = Integer.parseInt(res[0]);
        int d = Integer.parseInt(res[1]);
        int a = Integer.parseInt(res[2]);

        if(k+a<d || d == 0){
            System.out.println("hasu");
        }else{
            System.out.println("gosu");
        }
    }
}