package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
실행 시간 : 280ms
메 모 리 : 12208KB
*/

public class BOJ_10971_외판원순회2_S2 {

    static int N, ans = Integer.MAX_VALUE, start;
    static int[][] map;
    static boolean[] visited;
    private static void dfs(int visitNum, int cur, int len){
        if(visitNum == N){
            if(map[cur][start] != 0){
                len += map[cur][start];
                ans = Math.min(ans, len);
            }
            return;
        }

        for(int i = 0; i < N; i++){
            if(visited[i] || map[cur][i] == 0) continue;

            visited[i] = true;
            dfs(visitNum+1, i, len+map[cur][i]);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            start = i;
            visited = new boolean[N];
            visited[i] = true;
            dfs(1, i, 0);
        }
        System.out.println(ans);

    }
}