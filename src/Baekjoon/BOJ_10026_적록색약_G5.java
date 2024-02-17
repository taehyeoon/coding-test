package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-02-17 23:10
종료 시간 : 24-02-17 23:30
실행시간 : 96ms
메 모 리 : 12856KB

고려사항
*/

public class BOJ_10026_적록색약_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, ans;
    static char[][] map;
    static boolean[][] isVisited;
    static int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }

    private static void print(){
        for (char[] row : map) System.out.println(Arrays.toString(row));
    }

    private static void solve(){

        ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(isVisited[i][j]) continue;
                ans++;
                bfs(i, j, map[i][j]);
            }
        }
        sb.append(ans).append(" ");

        ans = 0;
        for (int i = 0; i < N; i++) {
            Arrays.fill(isVisited[i], false);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(isVisited[i][j]) continue;
                ans++;
                bfsRG(i, j, map[i][j]);
            }
        }
        sb.append(ans);
    }
    private static void bfs(int si, int sj, char color){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{si, sj});
        isVisited[si][sj] = true;

        while (!q.isEmpty()){
            int[] cur = q.poll();

            int ni, nj;
            for (int i = 0; i < 4; i++){
                ni = cur[0] + d[i][0];
                nj = cur[1] + d[i][1];
                if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                if(isVisited[ni][nj]) continue;
                if(map[ni][nj] != color) continue;

                isVisited[ni][nj] = true;
                q.add(new int[]{ni, nj});
            }
        }

    }

    private static void bfsRG(int si, int sj, char color){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{si, sj});
        isVisited[si][sj] = true;

        while (!q.isEmpty()){
            int[] cur = q.poll();

            int ni, nj;
            for (int i = 0; i < 4; i++){
                ni = cur[0] + d[i][0];
                nj = cur[1] + d[i][1];
                if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                if(isVisited[ni][nj]) continue;

                if(color == 'B' && map[ni][nj] != 'B') continue;
                if(color != 'B' && map[ni][nj] == 'B') continue;

                isVisited[ni][nj] = true;
                q.add(new int[]{ni, nj});
            }
        }
    }


    public static void main(String[] args) throws IOException {

        input();
        solve();
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
