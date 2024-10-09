package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-17
종료 시간 : 24-03-17
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1655_가운데를말해요_G1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] order;

    static PriorityQueue<Integer> pq;

    private static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        order = new int[N];
        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            order[i] = Integer.parseInt(br.readLine());
        }
    }

    private static int getMiddle(PriorityQueue<Integer> copyPQ, int n) {

        int extract = n % 2 == 0 ? n/2-1 : n/2;

        int res = -1;
        for (int i = 0; i < extract; i++) {
            res = copyPQ.poll();
        }

        return res;

    }
    public static void main(String[] args) throws IOException {

        input();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            pq.offer(order[i]);
            sb.append(getMiddle(new PriorityQueue<>(pq), i+1)).append("\n");
        }

        System.out.println(sb);
    }


}