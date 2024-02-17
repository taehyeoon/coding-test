package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-17 11:35
종료 시간 : 24-02-17 11:53
실행시간 : 116ms
메 모 리 : 13668KB
*/

public class BOJ_4963_섬의개수_S2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int W, H, ans;
    static int[][] map;
    static boolean[][] isVisited;
    static int[][] d = {{-1,-1}, {-1,0}, {-1,1},
                        {0,-1}, {0,1},
                        {1,-1}, {1,0}, {1,1}};

    private static void input() throws IOException {

        while(true){
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if(W == 0 && H == 0) return;

            map = new int[H][W];
            isVisited = new boolean[H][W];
            ans = 0;

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            solve();
            sb.append(ans).append("\n");
        }
    }


    private static void solve() {

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(isVisited[i][j]) continue;
                if(map[i][j] == 0) continue;

                ans++;
                bfs(i, j);
            }
        }
    }

    private static void bfs(int si, int sj){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{si, sj});
        isVisited[si][sj] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int ni, nj;
            for (int i = 0; i < 8; i++) {
                ni = cur[0] + d[i][0];
                nj = cur[1] + d[i][1];

                if(ni < 0 || nj < 0 || ni >= H || nj >= W) continue;
                if(isVisited[ni][nj]) continue;
                if(map[ni][nj] == 0) continue;

                isVisited[ni][nj] = true;

                q.add(new int[]{ni, nj});
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
