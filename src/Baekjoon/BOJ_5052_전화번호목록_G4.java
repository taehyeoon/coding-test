package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_5052_전화번호목록_G4 {

    static class Node {

        Node[] next = new Node[10];
        boolean isLast;

    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static void insert(String s){

    }

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {

            Node root = new Node();
            int N = Integer.parseInt(br.readLine());
            String[] numbers = new String[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = br.readLine();
            }




//            sb.append(ans);
        }
        System.out.println(sb);
    }
}