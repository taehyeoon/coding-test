package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 나는야 포켓몬 마스터 이다솜 1620 S4
시작 시간 : 24-01-23 01:00
종료 시간 : 24-01-23 01:14
실행시간 : 2312ms

고려사항
Map 자료구조를 이용하여
String-Integer
Integer-String
양쪽 자료구조에 모두 저장하여 빠른 탐색을 구현
*/

public class Solution1620 {

    static int N, M;
    static StringTokenizer st;
    static Map<String, Integer> strToInt = new HashMap<>();
    static Map<Integer, String> intToStr = new HashMap<>();
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            strToInt.put(s, i+1);
            intToStr.put(i+1, s);
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            boolean isNumeric = s.matches("[+-]?\\d*(\\.\\d+)?");
            if(isNumeric){
                System.out.println(intToStr.get(Integer.parseInt(s)));
            }else{
                System.out.println(strToInt.get(s));
            }

        }

    }
}