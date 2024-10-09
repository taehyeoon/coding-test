package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1736_쓰레기치우기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, trashCnt;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a == 1) trashCnt++;
                map[i][j] = a;
            }
        }

        int ans = 0;
        while(trashCnt > 0) {
            ans++;

            clean(0,0);
        }

        System.out.println(ans);
    }

    private static void clean(int ci, int cj) {

        if (ci == N - 1 && cj == M - 1) {
            if (map[ci][cj] == 1) {
                trashCnt--;
                map[ci][cj] = 0;
            }
            return;
        }

        for (int i = ci; i < N; i++) {
            for (int j = cj; j < M; j++) {
                if(map[i][j] == 1) {
                    map[i][j] = 0;
                    trashCnt--;
                    clean(i,j);
                    return;
                }
            }
        }
    }
}