package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-10-21
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_14948_군대탈출하기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] level;

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        level = new int[N][M];
        int[][][] dp = new int[N][M][2]; // 0 : 스킵x, 1 : 스킵o

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                level[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<int[]> q = new LinkedList<>(); // i, j, skill
        q.add(new int[] {0, 0, 0});
        dp[0][0][0] = level[0][0];
        dp[0][0][1] = 0;

        while (!q.isEmpty()) {
            int[] c = q.poll();
            int ci = c[0], cj = c[1];
            boolean alreadyUsed = c[2] == 1;

            for (int i = 0; i < 4; i++) {
                int ni = ci + di[i], nni = ci + 2 * di[i];
                int nj = cj + dj[i], nnj = cj + 2 * dj[i];

                if (alreadyUsed) {
                    if (isInside(ni, nj)) {
                        int nlevel = Math.max(dp[ci][cj][1], level[ni][nj]);
                        if(nlevel < dp[ni][nj][1]){
                            dp[ni][nj][1] = nlevel;
                            q.add(new int[] {ni, nj, 1});
                        }
                    }

                } else {
                    if(isInside(ni, nj)){
                        int nlevel = Math.max(dp[ci][cj][0], level[ni][nj]);
                        if(nlevel < dp[ni][nj][0]){
                            dp[ni][nj][0] = nlevel;
                            q.add(new int[] {ni, nj, 0});
                        }
                    }

                    if(isInside(nni, nnj)){
                        int nlevel = Math.max(dp[ci][cj][0], level[nni][nnj]);
                        if(nlevel < dp[nni][nnj][1]){
                            dp[nni][nnj][1] = nlevel;
                            q.add(new int[] {nni, nnj, 1});
                        }
                    }
                }

            }

        }
        System.out.println(Math.min(dp[N - 1][M - 1][0], dp[N - 1][M - 1][1]));

    }
    private static boolean isInside(int i, int j){
        return i >= 0 && i < N && j >= 0 && j < M;
    }
}