package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-30
종료 시간 : 24-03-30
실행 시간 : 96ms
메 모 리 : 12296KB
*/

public class BOJ_1726_로봇_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int H, W;
    static int[][] map;
    static int[] S, E;
    static boolean[][][] visit;

    static int[] di = {-99, 0, 0, 1, -1};
    static int[] dj = {-99, 1, -1, 0, 0};

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visit = new boolean[H][W][5];

        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int pi = Integer.parseInt(st.nextToken());
        int pj = Integer.parseInt(st.nextToken());
        int pd = Integer.parseInt(st.nextToken());
        S = new int[] {pi-1, pj-1, pd, 0};

        st = new StringTokenizer(br.readLine());
        pi = Integer.parseInt(st.nextToken());
        pj = Integer.parseInt(st.nextToken());
        pd = Integer.parseInt(st.nextToken());
        E = new int[] {pi-1, pj-1, pd, 0};
    }

    private static boolean isEnd(int[] pos) {
        return pos[0] == E[0] && pos[1] == E[1] && pos[2] == E[2];
    }

    private static int turnLeft(int d) {

        if(d == 4) return 2;
        if(d == 2) return 3;
        if(d == 3) return 1;
        else return 4;
    }

    private static int turnRight(int d) {

        if(d == 4) return 1;
        if(d == 2) return 4;
        if(d == 3) return 2;
        else return 3;
    }

    private static int bfs() {

        visit[S[0]][S[1]][S[2]] = true;

        // x, y, dir, move
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(S);

        while(!q.isEmpty()) {

            int qSize = q.size();

            for(int it = 0; it < qSize; it++) {

                int[] cur = q.poll();
                int ci = cur[0], cj = cur[1], curDir = cur[2], move = cur[3];

                if(isEnd(cur)) {
                    return move;
                }

                // 1,2,3 이동
                for(int m = 1; m <= 3; m++) {
                    int ni = ci + di[curDir] * m;
                    int nj = cj + dj[curDir] * m;

                    if(ni < 0 || nj < 0 || ni >= H || nj >= W) break;
                    if(visit[ni][nj][curDir]) continue;
                    if(map[ni][nj] == 1) break;

                    visit[ni][nj][curDir] = true;

                    q.offer(new int[] {ni, nj, curDir, move+1});
                }

                // 회전
                int left = turnLeft(curDir);
                int right = turnRight(curDir);

                if(!visit[ci][cj][left]){
                    q.offer(new int[] {ci, cj, left, move+1});
                    visit[ci][cj][left] = true;
                }
                if(!visit[ci][cj][right]){
                    q.offer(new int[] {ci, cj, right, move+1});
                    visit[ci][cj][right] = true;
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        input();

        System.out.println(bfs());

    }
}