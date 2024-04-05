package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-05 19:10
종료 시간 : 24-04-05 10:55
실행 시간 : 408ms
메 모 리 : 107116KB
*/

public class BOJ_22944_죽음의비_G3 {

    static class State{
        int i, j, hp, umbD, move;

        public State(int i, int j, int hp, int umbD, int move) {
            this.i = i;
            this.j = j;
            this.hp = hp;
            this.umbD = umbD;
            this.move = move;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, H, D, SI, SJ;
    static char[][] map;
    static int[][] visited;

    static int[][] delta = {{-1,0}, {1,0}, {0,1}, {0,-1}};

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'S'){
                    SI = i; SJ = j;
                }
            }
        }
    }

    private static State moveTo(State prev, int ni, int nj){

        State next = new State(ni, nj, prev.hp, prev.umbD, prev.move+1);

        if(map[ni][nj] == 'U') next.umbD = D;

        if(next.umbD != 0) next.umbD--;
        else next.hp--;

        return next;

    }
    public static void main(String[] args) throws IOException {

        input();

        int ans = Integer.MAX_VALUE;
        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(SI, SJ,H,0,0));
        visited[SI][SJ] = H;

        Find:
        while (!q.isEmpty()) {

            State cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ni = cur.i + delta[i][0];
                int nj = cur.j + delta[i][1];

                if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;

                if(map[ni][nj] == 'E') {
                    ans = Math.min(ans, cur.move+1);
                    continue ;
                }

                State next = moveTo(cur, ni, nj);
                if(next.hp == 0) continue ;

                if(next.umbD+next.hp > visited[ni][nj]){
                    visited[ni][nj] = next.umbD+next.hp;
                    q.offer(next);
                }
            }
        }

        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }
}