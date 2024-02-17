package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-17 11:55
종료 시간 : 24-02-18 00:20
실행시간 : 232ms
메 모 리 : 70504KB
*/

public class BOJ_7562_나이트의이동_S1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int TC, N, ans;
    static int SI, SJ, EI, EJ;
    static int[][] map;
    static boolean[][] isVisited;
    static int[][] d = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
                        {1, -2}, {2, -1}, {2, 1}, {1, 2}};

    private static void input() throws IOException {

        TC = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < TC; tc++){

            N = Integer.parseInt(br.readLine());
            ans = 0;
            map = new int[N][N];
            isVisited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            SI = Integer.parseInt(st.nextToken());
            SJ = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            EI = Integer.parseInt(st.nextToken());
            EJ = Integer.parseInt(st.nextToken());

            bfs();
            sb.append(ans).append("\n");
        }

    }

    private static void bfs(){

        if(SI == EI && SJ == EJ) return;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{SI, SJ});
        isVisited[SI][SJ] = true;

        while (!q.isEmpty()) {

            ans++;
            int q_size = q.size();
            for(int iter = 0; iter < q_size; iter++){

                int[] cur = q.poll();

                int ni, nj;
                for (int i = 0; i < 8; i++) {
                    ni = cur[0] + d[i][0];
                    nj = cur[1] + d[i][1];

                    if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                    if(isVisited[ni][nj]) continue;
                    if(ni == EI && nj == EJ) return;
                    isVisited[ni][nj] = true;
                    q.add(new int[]{ni, nj});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {

        input();
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
