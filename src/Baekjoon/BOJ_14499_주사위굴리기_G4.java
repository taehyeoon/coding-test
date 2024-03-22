package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-21 00:05
종료 시간 : 24-03-21 00:52
실행 시간 : 92ms
메 모 리 : 12036KB
*/

public class BOJ_14499_주사위굴리기_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int H, W, CI, CJ, K;
    static int[][] map;
    static int[] cmds;
    static int[] dice; // 위, 바닥, 상, 하, 좌, 우

    static int[] di = {-99, 0, 0, -1, 1};
    static int[] dj = {-99, 1, -1, 0, 0};

    enum Dir{
        TOP, BOTTOM, FRONT, BACK, LEFT, RIGHT
    }

    private static void input() throws IOException{

        dice = new int[6];

        st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        CI = Integer.parseInt(st.nextToken());
        CJ = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cmds = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            cmds[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void up(){
        int[] next = new int[6];

        next[Dir.TOP.ordinal()] = dice[Dir.FRONT.ordinal()];
        next[Dir.BOTTOM.ordinal()] = dice[Dir.BACK.ordinal()];
        next[Dir.FRONT.ordinal()] = dice[Dir.BOTTOM.ordinal()];
        next[Dir.BACK.ordinal()] = dice[Dir.TOP.ordinal()];
        next[Dir.LEFT.ordinal()] = dice[Dir.LEFT.ordinal()];
        next[Dir.RIGHT.ordinal()] = dice[Dir.RIGHT.ordinal()];

        dice = next;
    }
    private static void down(){
        int[] next = new int[6];

        next[Dir.TOP.ordinal()] = dice[Dir.BACK.ordinal()];
        next[Dir.BOTTOM.ordinal()] = dice[Dir.FRONT.ordinal()];
        next[Dir.FRONT.ordinal()] = dice[Dir.TOP.ordinal()];
        next[Dir.BACK.ordinal()] = dice[Dir.BOTTOM.ordinal()];
        next[Dir.LEFT.ordinal()] = dice[Dir.LEFT.ordinal()];
        next[Dir.RIGHT.ordinal()] = dice[Dir.RIGHT.ordinal()];

        dice = next;
    }
    private static void left(){
        int[] next = new int[6];

        next[Dir.TOP.ordinal()] = dice[Dir.RIGHT.ordinal()];
        next[Dir.BOTTOM.ordinal()] = dice[Dir.LEFT.ordinal()];
        next[Dir.LEFT.ordinal()] = dice[Dir.TOP.ordinal()];
        next[Dir.RIGHT.ordinal()] = dice[Dir.BOTTOM.ordinal()];
        next[Dir.FRONT.ordinal()] = dice[Dir.FRONT.ordinal()];
        next[Dir.BACK.ordinal()] = dice[Dir.BACK.ordinal()];

        dice = next;
    }
    private static void right(){
        int[] next = new int[6];

        next[Dir.TOP.ordinal()] = dice[Dir.LEFT.ordinal()];
        next[Dir.BOTTOM.ordinal()] = dice[Dir.RIGHT.ordinal()];
        next[Dir.LEFT.ordinal()] = dice[Dir.BOTTOM.ordinal()];
        next[Dir.RIGHT.ordinal()] = dice[Dir.TOP.ordinal()];
        next[Dir.FRONT.ordinal()] = dice[Dir.FRONT.ordinal()];
        next[Dir.BACK.ordinal()] = dice[Dir.BACK.ordinal()];

        dice = next;
    }
    private static boolean roll(int moveDir){

        int ni = CI + di[moveDir];
        int nj = CJ + dj[moveDir];

        if(ni < 0 || nj < 0 || ni >= H || nj >= W) return false;

        switch (moveDir){
            case 1: right(); break;
            case 2: left(); break;
            case 3: up(); break;
            case 4: down(); break;
        }

        CI = ni; CJ = nj;

        if(map[CI][CJ] == 0){
            map[CI][CJ] = dice[Dir.BOTTOM.ordinal()];
        }else{
            dice[Dir.BOTTOM.ordinal()] = map[CI][CJ];
            map[CI][CJ] = 0;
        }

        return true;
    }
    public static void main(String[] args) throws IOException {

        input();

        StringJoiner sj = new StringJoiner("\n");
        for (int i = 0; i < K; i++) {
            if(roll(cmds[i])){
                sj.add(Integer.toString(dice[Dir.TOP.ordinal()]));
            }
        }
        System.out.println(sj);
    }
}