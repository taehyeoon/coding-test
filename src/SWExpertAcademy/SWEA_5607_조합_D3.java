package com.ssafy.coding;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-01
종료 시간 : 24-04-01
실행시간 : 131ms
메 모 리 : 33240 KB
*/

public class SWEA_5607_조합_D3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, R;
	static final long MOD = 1_234_567_891;
	static long[] dp = new long[1_000_001];

	
	private static long calc(long n, long k) {
		
		if(k == 0) return 1;
		
		long x = calc(n, k/2) % MOD;
		if(k % 2 == 0) return x * x % MOD;
		else return ((x*x)%MOD * n) % MOD;
	}
	
	private static void init() {
		dp[1] = 1;
		for(int i = 2; i <= 1_000_000;i++) {
			dp[i] = (dp[i-1] * i) % MOD;
		}

	}
	
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		init();
		for(int tc = 1; tc <= TC; tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			long up = dp[N];
			long bottom = (dp[R] * dp[N-R]) % MOD;  

			long res = (up%MOD * calc(bottom, MOD-2)) % MOD;
			sb.append(String.format("#%d %d%n", tc, res));
		}
		System.out.println(sb);
	}
}
