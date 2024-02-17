package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-17 20:00
종료 시간 : 24-02-17 20:40
실행시간 : 364ms
메 모 리 : 42288KB
*/

public class BOJ_11404_플로이드_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static final int INF = 100_000_000;
    static int[][] edge;

    private static void input() throws IOException {

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        edge = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(edge[i], INF);
            edge[i][i] = 0;
        }

        int s, e, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            edge[s][e] = Math.min(edge[s][e], v);
        }
    }

    private static void print() throws IOException {
        sb.setLength(0);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(edge[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
    }

    private static void solve(){

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    edge[i][j] = Math.min(edge[i][j], edge[i][k] + edge[k][j]);
                }
            }
        }

        // INF to 0
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N ; j++) {
                if(edge[i][j] == INF) edge[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        input();
        solve();
        print();

        br.close();
        bw.close();
    }
}
