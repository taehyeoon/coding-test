package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-04 21:00
종료 시간 : 24-03-04 21:30
실행 시간 : 536ms / 실패
메 모 리 : 31796KB
*/

public class BOJ_14500_테트로미노_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int H, W, ans;
    static int[][] map;
    static boolean[][] visited;

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = { 0, 0,-1, 1};


    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void calcShape(int ci, int cj, int bannedDir){

        int sum = map[ci][cj];
        for (int i = 0; i < 4; i++) {
            if(i == bannedDir) continue;

            int ni = ci + di[i];
            int nj = cj + dj[i];
            if(ni < 0 || nj < 0 || ni >= H || nj >= W) return;

            sum += map[ni][nj];
        }

        ans = Math.max(ans, sum);
    }

    private static void dfs(int ci, int cj, int cnt, int sum){
        if(cnt == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        // ㅗ,ㅜ,ㅓ,ㅏ 모양
        if(cnt == 1){
            for (int i = 0; i < 4; i++) {
                calcShape(ci, cj, i);
            }
        }

        for (int i = 0; i < 4; i++) {
            int ni = ci + di[i];
            int nj = cj + dj[i];

            if(ni < 0 || nj < 0 || ni >= H || nj >= W) continue;
            if(visited[ni][nj]) continue;

            visited[ni][nj] = true;
            dfs(ni, nj, cnt+1, sum + map[ni][nj]);
            visited[ni][nj] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(ans);
    }
}