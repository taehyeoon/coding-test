package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-02 15:25
종료 시간 : 24-04-02 11:59
실행 시간 : 476ms / 실패
메 모 리 : 36368KB
*/

public class BOJ_17143_낚시왕_G1 {

    static class Shark {
        int r,c,s,d,z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int R, C, M, ans;
    static Shark[][] map;
    static Queue<Shark> sharks;

    static int[] di = {-99, -1, 1, 0, 0};
    static int[] dj = {-99,  0, 0, 1, -1};

    private static void input() throws IOException{

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R][C];

        // 상어
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if(d <= 2) s %= (R-1)*2;
            else s %= (C-1)*2;

            map[r][c] = new Shark(r,c,s,d,z);
        }
    }

    private static int turnback(int d) {

        if(d == 1) return 2;
        if(d == 2) return 1;
        if(d == 3) return 4;
        if(d == 4) return 3;
        return -1;
    }

    private static void fishing(int king){

        for (int row = 0; row < R; row++) {
            if(map[row][king] != null){
                ans += map[row][king].z;
                map[row][king] = null;
                return;
            }
        }
        
    }
    
    private static void getSharks(){

        sharks = new ArrayDeque<>();

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if(map[row][col] == null) continue;
                sharks.offer(map[row][col]);
            }
        }
    }
    
    private static void moveFish(){

        map = new Shark[R][C];
        
        while (!sharks.isEmpty()) {
            
            Shark cur = sharks.poll();

            int nr = cur.r, nc = cur.c;
            int dir = cur.d;
            for (int move = 0; move < cur.s; move++) {

                nr += di[dir]; nc += dj[dir];

                if(nr < 0 || nc < 0 || nr >= R || nc >= C){
                    nr -= di[dir]; nc -= dj[dir];
                    dir = turnback(dir);
                    nr += di[dir]; nc += dj[dir];
                }
            }

            if(map[nr][nc] == null || map[nr][nc].z < cur.z){
                cur.r = nr; cur.c = nc; cur.d = dir;
                map[nr][nc] = cur;
            }
        }
    }
    public static void main(String[] args) throws IOException {

        input();

        for(int king = 0; king < C; king++) {

            fishing(king);
    		getSharks();
    		moveFish();

        }

        System.out.println(ans);
    }
}