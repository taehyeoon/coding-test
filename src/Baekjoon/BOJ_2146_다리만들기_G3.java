package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-05 01:50
종료 시간 : 24-04-05 22:22
실행 시간 : 588ms
메 모 리 : 16704KB
*/

public class BOJ_2146_다리만들기_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, ans = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static List<List<int[]>> islands;

    static int[] combiResult;



    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0,-1}};

    private static void makeIsland(int si, int sj){

        List<int[]> island = new ArrayList<>();
        island.add(new int[]{si, sj});

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{si, sj});

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int ci = cur[0], cj = cur[1];

            for (int i = 0; i < 4; i++) {
                int ni = ci + dir[i][0];
                int nj = cj + dir[i][1];

                if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                if(visited[ni][nj]) continue;
                if(map[ni][nj] == 0) continue;

                visited[ni][nj] = true;
                q.offer(new int[]{ni, nj});
                island.add(new int[]{ni, nj});
            }
        }

        islands.add(island);
    }

    private static void calcMin(){

        int a = combiResult[0];
        int b = combiResult[1];

        for (int i = 0; i < islands.get(a).size(); i++) {
            for (int j = 0; j < islands.get(b).size(); j++) {

                int ai = islands.get(a).get(i)[0];
                int aj = islands.get(a).get(i)[1];
                int bi = islands.get(b).get(j)[0];
                int bj = islands.get(b).get(j)[1];

                ans = Math.min(ans, Math.abs(ai-bi) + Math.abs(aj-bj) - 1);
            }
        }
    }

    private static void combi(int cnt, int start){

        if(cnt == 2){
            calcMin();
            return;
        }

        for (int i = start; i < islands.size(); i++) {
            combiResult[cnt] = i;
            combi(cnt+1, i+1);
        }
    }
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][N];
        islands = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0 || visited[i][j]) continue;
                visited[i][j] = true;

                makeIsland(i, j);
            }
        }

        combiResult = new int[2];
        combi(0, 0);

        System.out.println(ans);
    }
}