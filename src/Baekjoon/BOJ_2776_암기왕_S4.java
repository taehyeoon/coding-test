package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-15 23:20
종료 시간 : 24-03-15 23:35
실행 시간 : 1712ms
메 모 리 : 385456KB
*/

public class BOJ_2776_암기왕_S4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){

            int n1 = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n1; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            int n2 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n2; i++) {
                if(set.contains(Integer.parseInt(st.nextToken()))){
                    sb.append("1\n");
                }else{
                    sb.append("0\n");
                }
            }
        }
        System.out.println(sb);
    }
}