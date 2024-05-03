package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
시작 시간 : 24-05-03 12:00
종료 시간 : 24-05-04 02:28
실행 시간 : 1936ms
메 모 리 : 14876KB
*/

public class BOJ_1184_귀농_G1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] map;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();

        int ans = 0;

        if(N == 1) {
            System.out.println(0);
            return;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= N; j++) {

                // 좌상
                for (int h = i-1; h >= 1; h--) {
                    for (int w = j-1; w >= 1; w--) {

                        int sum1 = map[i-1][j-1] - map[h-1][j-1] - map[i-1][w-1] + map[h-1][w-1];
                        // 우하
                        for (int h2 = i; h2 <= N; h2++) {
                            for (int w2 = j; w2 <= N; w2++) {
                                int sum2 = map[h2][w2] - map[i-1][w2] - map[h2][j-1] + map[i-1][j-1];

                                if(sum1 == sum2) {
                                    ans++;
                                }
                            }
                        }

                    }
                }

                // 우상
                for (int h = i-1; h > 0; h--) {
                    for (int w = j; w <= N; w++) {

                        int sum1 = map[i-1][w] - map[h-1][w] - map[i-1][j-1] + map[h-1][j-1];

                        // 좌하
                        for (int h2 = i; h2 <= N; h2++) {
                            for (int w2 = j-1; w2 > 0; w2--) {
                                int sum2 = map[h2][j-1] - map[i-1][j-1] - map[h2][w2-1] + map[i-1][w2-1];

                                if(sum1 == sum2) {
                                    ans++;
                                }
                            }
                        }

                    }
                }
            }
        }

        System.out.println(ans);
    }
}
