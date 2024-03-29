package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-30 02:00
종료 시간 : 24-03-30 02:05
실행 시간 : 1088ms
메 모 리 : 568420KB
*/

public class BOJ_11478_서로다른부분문자열의개수_S3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        int n = str.length();
        Map<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int size = 1; size <= n-i; size++) {
                String s = str.substring(i, i+size);
                if(!map.containsKey(s)) map.put(s, true);
            }
        }
        System.out.println(map.size());
    }
}