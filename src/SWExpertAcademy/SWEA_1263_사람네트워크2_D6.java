package com.ssafy.coding;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-29
종료 시간 : 24-03-29
실행시간 : 4032ms
메 모 리 : 107880KB
*/

public class SWEA_1263_사람네트워크2_D6 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	private static int N;
	private static int[][] adj;
	
	private static void input() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		adj = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				adj[i][j] = st.nextToken().equals("1") ? 1 : Integer.MAX_VALUE/2;
			}
		}
	}

	
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= TC; tc++) {
			
			int ans = 0;
			input();
			
			for(int k = 0; k < N; k++) {
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(i == j) continue;
						if(adj[i][k] + adj[k][j] < adj[i][j]) {
							adj[i][j] = adj[i][k] + adj[k][j];
						}
					}
				}
			}
			
			int minCC = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				int sum = 0;
				for(int j = 0; j < N; j++) {
					if(i == j) continue;
					sum += adj[i][j];
				}
				
				if(sum < minCC) {
					minCC = sum;
				}
			}
			
			
			sb.append(String.format("#%d %d%n", tc, minCC));
		}
		System.out.println(sb);
	}
}
