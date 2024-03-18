package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-18 21:00
종료 시간 : 24-03-18 21:46
실행 시간 : 236ms
메 모 리 : 30472KB
*/

public class BOJ_17406_배열돌리기4_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int H, W, K, ans = Integer.MAX_VALUE;
    static int[][] originMap, map;
    static int[][] cmd;
    static int[] order;
    static boolean[] visited;

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        originMap = new int[H+1][W+1];

        for (int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= W; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cmd = new int[K+1][];
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            cmd[i] = new int[]{r,c,s};
        }

        order = new int[K+1];
        visited = new boolean[K+1];
    }

    private static void rotate(int[] command){
        int r = command[0];
        int c = command[1];
        int s = command[2];

        int lti = r-s, ltj = c-s;

        int side = 2*s;
        for (int outter = 0; outter < s; outter++) {
            int startVal;
            int ci = lti + outter;
            int cj = ltj + outter;
            startVal = map[ci][cj];

            // 좌하 -> 좌상
            for (int i = 0; i < side; i++) {
                map[ci+i][cj] = map[ci+i+1][cj];
            }

            // 좌하 -> 우하
            for (int i = 0; i < side; i++) {
                map[ci+side][cj+i] = map[ci+side][cj+i+1];
            }

            // 우하 -> 우상
            for (int i = 0; i < side; i++) {
                map[ci+side-i][cj+side] = map[ci+side-i-1][cj+side];
            }

            // 우상 -> 좌상
            for (int i = 0; i < side; i++) {
                map[ci][cj+side - i] = map[ci][cj+side - i - 1];
            }

            map[ci][cj+1] = startVal;

            side -= 2;
        }
    }

    private static void calcMin(){

        int tempMin = Integer.MAX_VALUE;

        for (int i = 1; i <= H; i++) {
            int sum = 0;
            for (int j = 1; j <= W; j++) {
                sum += map[i][j];
            }
            tempMin = Math.min(tempMin, sum);
        }

        ans = Math.min(ans, tempMin);
    }
    private static void solve(int[] od){
        map = copyMap();

        for (int i = 1; i <= K; i++) {
            rotate(cmd[od[i]]);
        }
        calcMin();
    }

    private static void per(int cnt){

        if(cnt == K+1){
            solve(order);
            return;
        }

        for (int i = 1; i <= K; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            order[cnt] = i;
            per(cnt+1);
            visited[i] = false;
        }
    }

    private static int[][] copyMap(){
        int[][] temp = new int[H+1][W+1];
        for (int i = 1; i <= H; i++) {
            temp[i] = Arrays.copyOf(originMap[i], W+1);
        }

        return temp;
    }
    public static void main(String[] args) throws IOException {

        input();

        per(1);

        System.out.println(ans);
    }
}