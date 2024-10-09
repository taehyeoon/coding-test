package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-15 21:00
종료 시간 : 24-03-15
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1700_멀티탭스케줄링_G1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[] order;

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        order = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void main(String[] args) throws IOException {

        input();

        PriorityQueue<Integer> pq;

    }
}