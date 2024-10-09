package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_11657_타임머신 {

    static class Road{
        int s, e, c;
        Road(int s, int e, int c){
            this.s = s;
            this.e = e;
            this.c = c;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringJoiner sj = new StringJoiner("\n");

    static int N, M;
    static long[] dist;
    static Road[] roads;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new long[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        roads = new Road[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            roads[i] = new Road(s, e, c);
        }

        dist[1] = 0;
        boolean hasCycle = false;

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < M; j++) {

                int s = roads[j].s, e = roads[j].e, c = roads[j].c;

                if(dist[s] == Integer.MAX_VALUE) continue;

                // 최단 경로가 더 감소되는 경우
                if(dist[e] > dist[s] + c){
                    dist[e] = dist[s] + c;

                    if(i == N){
                        hasCycle = true;
                    }
                }
            }
        }

        if(hasCycle) {
            System.out.println("-1");
        }else{
            for (int i = 2; i <= N; i++) {
                if(dist[i] == Integer.MAX_VALUE)
                    sj.add("-1");
                else
                    sj.add(dist[i] + "");
            }
        }

        bw.write(sj.toString());
        bw.flush();


    }
}