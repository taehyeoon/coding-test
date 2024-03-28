package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-29
종료 시간 : 24-03-29
실행 시간 : 104ms / 실패
메 모 리 : 13328KB
*/

public class BOJ_1194_달이차오른다가자_G1 {

    static int N, M, ans;
    static char[][] map;
    static boolean[][][] visit;
    static int[] start;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M][1<<6];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == '0') start = new int[]{i, j, 0, 0};
            }
        }
    }

    private static boolean isDoor(int i, int j){
        return map[i][j] >= 'A' && map[i][j] <= 'F';
    }

    private static boolean canOpen(int key, char door){
        return ( key & 1 << (door - 'A') ) != 0;
    }

    private static boolean isKey(int i, int j){
        return map[i][j] >= 'a' && map[i][j] <= 'f';
    }

    private static void bfs() {

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visit[start[0]][start[1]][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int ci = cur[0];
            int cj = cur[1];
            int move = cur[2];
            int curKey = cur[3];

            if(map[ci][cj] == '1') {
                ans = move; return;
            }

            for (int i = 0; i < 4; i++) {
                int ni = ci + di[i];
                int nj = cj + dj[i];

                if(ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
                if(map[ni][nj] == '#') continue;
                if(visit[ni][nj][curKey]) continue;
                if(isDoor(ni, nj) && !canOpen(curKey, map[ni][nj])) continue;

                if(isKey(ni, nj)){
                    int nextKey = curKey | 1 << map[ni][nj] - 'a';

                    visit[ni][nj][curKey] = true;
                    visit[ni][nj][nextKey] = true;
                    q.offer(new int[]{ni, nj, move+1, nextKey});
                }

                else{
                    visit[ni][nj][curKey] = true;
                    q.offer(new int[]{ni, nj, move+1, curKey});

                }
            }
        }

        ans = -1;
    }
    public static void main(String[] args) throws IOException {

        input();

        bfs();

        System.out.println(ans);
    }
}