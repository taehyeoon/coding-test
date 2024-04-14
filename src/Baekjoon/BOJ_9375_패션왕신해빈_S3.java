package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-14 10:36
종료 시간 : 24-04-14 10:48
실행 시간 : 84ms
메 모 리 : 11836KB
*/

public class BOJ_9375_패션왕신해빈_S3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {

            Map<String, Integer> map = new HashMap<>();

            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                String item = st.nextToken();
                String category = st.nextToken();

                map.put(category, map.getOrDefault(category,0)+1);
            }


            int mul = 1;
            for(Map.Entry<String, Integer> s :  map.entrySet()){
                mul *= s.getValue()+1;
            }
            sb.append(mul-1).append("\n");

        }

        System.out.println(sb);
    }
}