package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-13 23:40
종료 시간 : 24-05-13 23:53
실행 시간 : 284ms
메 모 리 : 25936KB
*/

public class BOJ_21736_헌내기는친구가필요해_S2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, start[];
    static char[][] map;
    static boolean[][] visited;
    static int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
                if (c == 'I'){
                    start = new int[]{i, j};
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        input();

        Queue<int[]> q = new ArrayDeque<>();
        visited[start[0]][start[1]] = true;
        q.add(start);


        int cnt = 0;
        while (!q.isEmpty()) {
            int ci = q.peek()[0];
            int cj = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int ni = ci + delta[i][0];
                int nj = cj + delta[i][1];
                if(ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
                if(map[ni][nj] == 'X' || visited[ni][nj]) continue;

                if(map[ni][nj] == 'P') cnt++;
                visited[ni][nj] = true;
                q.add(new int[]{ni, nj});
            }
        }

        System.out.println(cnt == 0 ? "TT" : cnt);
    }
}