package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_5875_오타_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        String str = br.readLine();
        int len = str.length();
        int l = 0;
        int r = 0;
        int total = 0;
        int result = 0;

        for (int i = 0; i < len; i++) {
            char value = str.charAt(i);
            if (value == '(') {
                l++;
                total++;
            } else {
                r++;
                total--;
            }
            if (total == 1) {
                l = 0;
            }
            if (total == -1) {
                result = r;
                break;
            }
        }
        if (total == 2) {
            result = l;
        }
        System.out.println(result);
    }
}