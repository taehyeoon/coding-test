package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-04 21:40
종료 시간 : 24-03-04 22:15
실행 시간 : 328ms
메 모 리 : 17652KB
*/

public class BOJ_11403_경로찾기_S1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] map, result;

    private static void input() throws IOException{
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        result = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }


    private static void bfs(int s){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        boolean[] visited = new boolean[N];

        while (!q.isEmpty()) {
            int cur = q.poll();

            for(int i = 0; i < N; i++){
                if(visited[i]) continue;
                if(map[cur][i] == 0) continue;

                visited[i] = true;
                result[s][i] = 1;
                q.offer(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {

        input();

        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}