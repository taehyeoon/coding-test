package com.cardCompany;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7579 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M;
	static int[][] dp;
	static int[] c, m;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dp = new int[N][10_001];
		c = new int[N];
		m = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int memory = m[i];
			int cost = c[i];

			for (int j = 0; j <= 10_000; j++) {
				if(i == 0){
					if(j >= cost) dp[i][j] = memory;
				}else{
					if(j >= cost) dp[i][j] = Math.max(dp[i-1][j-cost] + memory, dp[i-1][j]);
					else dp[i][j] = dp[i-1][j];
				}

				if(dp[i][j] >= M){
					ans = Math.min(ans, j);
				}
			}
		}
		System.out.println(ans);


	}
}