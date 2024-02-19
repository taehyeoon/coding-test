package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-02-18 20:50
종료 시간 : 24-02-18 21:00
실행 시간 : 236ms
메 모 리 : 18400KB
*/

public class BOJ_1389_케빈베이컨의6단계법칙_S1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;


    static int N, M;
    static int[][] link;
    static final int INF = 100_000_000;
    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        link = new int[N+1][N+1];

        for (int i = 0; i < N+1; i++) {
            Arrays.fill(link[i], INF);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            link[a][b] = 1;
            link[b][a] = 1;
        }
    }

    private static void solve(){

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(i == j) continue;
                    if(link[i][j] > link[i][k] + link[k][j]){
                        link[i][j] = link[i][k] + link[k][j];
                    }
                }
            }
        }

        int[][] bacon = new int[N][2]; // idx, baconNum
        for (int i = 1; i <= N; i++) {
            bacon[i-1][0] = i;
            for (int j = 1; j <= N ; j++) {
                if(i == j) continue;
                bacon[i-1][1] += link[i][j];
            }
        }

        Arrays.sort(bacon, ((o1, o2) ->
        {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        }));

        System.out.println(bacon[0][0]);
    }

    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.close();
        br.close();
    }
}
