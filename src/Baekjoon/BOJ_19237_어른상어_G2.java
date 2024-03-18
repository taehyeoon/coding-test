package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-16 20:05
종료 시간 : 24-03-17 01:30
실행 시간 : 200ms
메 모 리 : 27656KB
*/

public class BOJ_19237_어른상어_G2 {

    static class Data{
        int sharkIdx, smell, time, dir;

        public Data(int sharkIdx, int smell, int time, int dir) {
            this.sharkIdx = sharkIdx;
            this.smell = smell;
            this.time = time;
            this.dir = dir;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Data[][] map, tempMap;
    static int[][][] priority; // 상어번호, 현재상어방향, 타겟방향
    static int N, M, K, survive;
    static int[] di = {-99, -1, 1, 0, 0};
    static int[] dj = {-99,  0, 0, -1, 1};

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new Data[N][N];
        survive = M;

        // map 상태
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if(val != 0) map[i][j] = new Data(val, val, K,0);
                else map[i][j] = new Data(val, 0, 0, 0);
            }
        }

        // 상어 방향
        st = new StringTokenizer(br.readLine());
        int[] order = new int[M+1];
        for (int i = 1; i <= M; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        // 상어 방향 초기화
        int sh = 1;
        while (sh <= M){
            FindShark:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j].sharkIdx == sh){
                        map[i][j].dir = order[sh];
                        break FindShark;
                    }
                }
            }
            sh++;
        }

        // 상어 우선순위
        priority = new int[M + 1][5][5];
        for (int i = 1; i <= M; i++) {

            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= 4; k++) {
                    priority[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }

    private static void moveSingleShark(int ci, int cj){

        int sharkNum = map[ci][cj].sharkIdx;
        int sharkDir = map[ci][cj].dir;

        // 냄새 없는 곳 찾기
        for (int i = 1; i <= 4; i++) {
            int dirIdx = priority[sharkNum][sharkDir][i];
            int ni = ci + di[dirIdx];
            int nj = cj + dj[dirIdx];

            if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
            if(map[ni][nj].smell != 0) continue;

            // 이미 나보다 작은 상어가 있다면 쫓겨남
            if(tempMap[ni][nj].sharkIdx != 0) {
                survive--;
                return;
            }
            // 냄새 뿌리기
            tempMap[ni][nj].sharkIdx = sharkNum;
            tempMap[ni][nj].dir = dirIdx;
            tempMap[ni][nj].smell = sharkNum;
            tempMap[ni][nj].time = K;
            return;
        }

        // 본인 냄새 찾기
        for (int i = 1; i <= 4; i++) {
            int dirIdx = priority[sharkNum][sharkDir][i];

            int ni = ci + di[dirIdx];
            int nj = cj + dj[dirIdx];

            if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
            if(map[ni][nj].smell != sharkNum) continue;

            if(tempMap[ni][nj].sharkIdx != 0) {
                survive--;
                return;
            }
            // 냄새 뿌리기
            tempMap[ni][nj].sharkIdx = sharkNum;
            tempMap[ni][nj].dir = dirIdx;
            tempMap[ni][nj].smell = sharkNum;
            tempMap[ni][nj].time = K;

            return;
        }
    }

    private static void copyMap(){

        tempMap = new Data[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Data cur = map[i][j];
                tempMap[i][j] = new Data(0, cur.smell, cur.time, 0);
            }
        }
    }

    private static void sharkMove(){
        // 상어 중복 방지를 위한 맵 복사
        copyMap();

        int sharkIdx = 1;
        while (sharkIdx <= M) {

            FindShark:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if(map[i][j].sharkIdx == sharkIdx){

                        moveSingleShark(i, j);

                       break FindShark;
                    }
                }
            }
            sharkIdx++;
        }

        map = tempMap;
    }

    private static void smellDecrease(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j].sharkIdx!=0) continue;
                if(map[i][j].time > 0) map[i][j].time--;
                if(map[i][j].time == 0) map[i][j].smell = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {

        input();

        for (int time = 1; time <= 1000; time++) {

            // 1번 상어부터 이동
            sharkMove();

            // 상어가 1마리이면 time 출력, 종료
            if(survive == 1){
                System.out.println(time);
                return;
            }
            // 냄새 1 감소시키기
            smellDecrease();
        }

        System.out.println(-1);
    }
}