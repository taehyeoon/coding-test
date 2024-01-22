package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 문자와 문자열 27866 B5
시작 시간 : 24-01-22 00:47
종료 시간 : 24-01-21 00:49
실행시간 : 76ms

고려사항
*/

public class Solution27866 {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int x = Integer.parseInt(br.readLine());
        System.out.println(s.charAt(x-1));
    }
}