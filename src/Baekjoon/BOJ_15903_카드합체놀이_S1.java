package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-30 13:00
종료 시간 : 24-03-30 13:15
실행 시간 : 124ms
메 모 리 : 13188KB
*/

public class BOJ_15903_카드합체놀이_S1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int N, M;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            long a = pq.poll();
            long b = pq.poll();
            pq.offer(a+b);
            pq.offer(a+b);
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum+=pq.poll();
        }
        System.out.println(sum);

    }
}