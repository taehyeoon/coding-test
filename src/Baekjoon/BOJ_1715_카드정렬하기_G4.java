package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-20 01:00
종료 시간 : 24-02-20 01:24
실행 시간 : 300ms
메 모 리 : 22464KB
*/

public class BOJ_1715_카드정렬하기_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static PriorityQueue<Long> pq;
    static private void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(br.readLine()));
        }
    }

    private static void solve() {

        if(pq.size() == 1) {
            sb.append(0);
            return;
        }

        long ans = 0;

        while(pq.size() != 1){
            long a = pq.poll();
            long b = pq.poll();
            ans += a + b;
            pq.offer(a+b);
        }
        sb.append(ans);
    }

    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
