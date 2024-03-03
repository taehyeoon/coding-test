package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-03 18:00
종료 시간 : 24-03-03 18:30
실행 시간 : 588ms
메 모 리 : 96216KB
*/

public class BOJ_7569_토마토_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int M, N, H, day;
    static int[][][] map;
    static boolean[][][] visited;
    static int unRiped;
    static Queue<int[]> q = new ArrayDeque<>();

    static int[] di = {-1, 1, 0, 0, 0, 0};
    static int[] dj = { 0, 0,-1, 1, 0, 0};
    static int[] dk = { 0, 0, 0, 0,-1, 1};

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int val = Integer.parseInt(st.nextToken());
                    map[i][j][k] = val;

                    if(val == 0) unRiped++;
                    else if(val == 1) {
                        q.offer(new int[]{i,j,k});
                        visited[i][j][k] = true;
                    }
                }
            }
        }
    }

    private static boolean isOutRange(int i, int j, int k){
        return i < 0 || i >= H || j < 0 || j >= N || k < 0 || k >= M;
    }

    public static void main(String[] args) throws IOException {
        
        input();

        if(unRiped == 0){
            System.out.println(0);
            return;
        }

        while (!q.isEmpty()) {
            day++;
            for (int iter = 0, size = q.size(); iter < size; iter++) {
                int[] cur = q.poll();
                int ci=cur[0], cj=cur[1], ck=cur[2];

                map[ci][cj][ck] = 1;

                for (int i = 0; i < 6; i++) {
                    int ni = ci+di[i];
                    int nj = cj+dj[i];
                    int nk = ck+dk[i];

                    if(isOutRange(ni, nj, nk)) continue;
                    if(map[ni][nj][nk] != 0) continue;
                    if(visited[ni][nj][nk]) continue;

                    unRiped--;
                    visited[ni][nj][nk] = true;
                    q.offer(new int[]{ni, nj, nk});
                }
            }
        }

        if(unRiped != 0){
            System.out.println(-1);
            return;
        }

        System.out.println(day-1);
    }
}