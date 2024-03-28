package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-29 01:10
종료 시간 : 24-03-29 01:50
실행 시간 : 92ms
메 모 리 : 12024KB
*/

public class BOJ_3055_탈출_G4 {

    static int R, C, DI, DJ, SI, SJ;
    static char[][] map;
    static List<int[]> prevWater;

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        prevWater = new ArrayList<>();
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = str.charAt(j);
                map[i][j] = c;
                if(c == '*') prevWater.add(new int[]{i, j});
                else if(c == 'D') { DI = i; DJ = j; }
                else if(c == 'S') { SI = i; SJ = j; }
            }
        }
    }

    private static void flowWater(){

        List<int[]> nextWater = new ArrayList<>();

        for(int[] w : prevWater){
            for (int i = 0; i < 4; i++) {
                int ni = w[0] + di[i];
                int nj = w[1] + dj[i];
                if(ni < 0 || nj < 0 || ni >= R || nj >= C) continue;

                if(map[ni][nj] == '.') {
                    map[ni][nj] = '*';
                    nextWater.add(new int[]{ni, nj});
                }
            }
        }

        prevWater = nextWater;
    }

    private static int bfs(){

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];

        q.offer(new int[]{SI, SJ, 0});
        visited[SI][SJ] = true;

        while(!q.isEmpty()){

            flowWater();
            int qSize = q.size();

            for (int it = 0; it < qSize; it++) {
                int[] cur = q.poll();
                int ci = cur[0], cj = cur[1], ct = cur[2];

                for (int i = 0; i < 4; i++) {
                    int ni = ci + di[i];
                    int nj = cj + dj[i];
                    if(ni < 0 || nj < 0 || ni >= R || nj >= C) continue;

                    if(ni == DI && nj == DJ) return ct + 1;
                    if(map[ni][nj] == '*' || map[ni][nj] == 'X') continue;
                    if(visited[ni][nj]) continue;
                    visited[ni][nj] = true;

                    q.offer(new int[]{ni, nj, ct+1});
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {

        input();

        int res = bfs();

        System.out.println(res == -1 ? "KAKTUS" : res);
    }
}