package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-16 01:30
종료 시간 : 24-03-16 02:25
실행 시간 : 516ms
메 모 리 : 46172KB
*/

public class BOJ_13305_주유소_S3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] road;
    static PriorityQueue<long[]> pq;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        road = new int[N-1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++){
            road[i] = Integer.parseInt(st.nextToken());
        }

        pq = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[1] == o2[1]) return Long.compare(o1[0], o2[0]);
                else return Long.compare(o1[1],o2[1]);
            }
        });

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            pq.add(new long[]{i, Long.parseLong(st.nextToken())});
        }
    }

    public static void main(String[] args) throws IOException {

        input();

        long sum = 0;
        int last = N-1;

        while(last != 0){
            long[] cur = pq.poll();
            if(cur[0] > last) continue;

            for (int i = (int)cur[0]; i < last; i++) {
                sum += road[i] * cur[1];
            }
            last = (int)cur[0];
        }

        System.out.println(sum);
    }
}