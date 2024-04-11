package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-11 23:38
종료 시간 : 24-04-11 23:40
실행 시간 : 76ms
메 모 리 : 11464KB
*/

public class BOJ_9086_문자열_B5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TC; i++) {
            String str = br.readLine();
            sb.append(str.charAt(0)).append(str.charAt(str.length()-1)).append("\n");
        }
        System.out.println(sb);

    }
}