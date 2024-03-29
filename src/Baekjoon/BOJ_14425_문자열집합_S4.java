package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-30
종료 시간 : 24-03-30
실행 시간 : 5156ms
메 모 리 : 38584KB
*/

public class BOJ_14425_문자열집합_S4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int N, M;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<String> s1 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            s1.add(br.readLine());
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if(s1.contains(str)) cnt++;
        }
        System.out.println(cnt);
    }
}