package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-19 22:40
종료 시간 : 24-02-19 22:56
실행 시간 : 84ms
메 모 리 : 11860KB
*/

public class BOJ_10162_전자레인지_B3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T;


    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        int a = T / 300;
        T %= 300;
        int b = T / 60;
        T %= 60;
        int c = T / 10;
        T %= 10;

        if(T != 0) System.out.println(-1);
        else System.out.printf("%d %d %d",a,b,c);

        bw.close();
        br.close();
    }
}
