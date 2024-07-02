package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_2186_문자판_G3 {

    static int N, M, K;
    static long cnt = 0;
    static char[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][][] dp;
    static String answer;

    public static int dfs(int x, int y, int l) {
        if (dp[x][y][l] != -1) return dp[x][y][l];
        if (l == answer.length()-1) return dp[x][y][l] = 1;

        dp[x][y][l] = 0;

        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j] * i;
                int ny = y + dy[j] * i;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (board[nx][ny] == answer.charAt(l+1)) dp[x][y][l] += dfs(nx, ny, l + 1);
            }
        }
        return dp[x][y][l];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        answer = br.readLine();
        dp = new int[N][M][answer.length()];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == answer.charAt(0)) cnt += dfs(i, j, 0);
            }
        }

        System.out.println(cnt);
    }
}