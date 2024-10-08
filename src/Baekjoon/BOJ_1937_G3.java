package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1937_G3 {

	static int N;
	static int[][] map;
	static int[][] dp;
	static boolean[][] isVisited;
	static int maxRoute;

	static int[][] delta = {{-1,0}, {1,0}, {0,-1}, {0,1}};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				dp[i][j] = dfs(i, j);
				ans = Math.max(ans, dp[i][j]);
			}
		}

		System.out.println(ans);
	}

	private static int dfs(int ci, int cj){

		if(dp[ci][cj] > 0) return dp[ci][cj];

		int route = 1;
		for (int i = 0; i < 4; i++) {
			int ni = ci+delta[i][0];
			int nj = cj+delta[i][1];

			if(ni < 0 || ni >= N || nj < 0 || nj >= N) continue;

			if(map[ni][nj] > map[ci][cj]){
				route = Math.max(dfs(ni, nj)+1, route);
			}
		}

		dp[ci][cj] = route;
		// System.out.println(ci + " / " + cj + " = " + route);
		return route;
	}
}