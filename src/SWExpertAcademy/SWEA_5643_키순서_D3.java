package com.ssafy.coding;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-03 17:20
종료 시간 : 24-04-03 17:50
실행시간 : 1701ms
메 모 리 : 101124KB
*/


public class SWEA_5643_키순서_D3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	static boolean[][] go;
	
	private static void input() throws IOException{
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		go = new boolean[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			go[a][b] = true;
		}
	}
	
	public static void main(String[] args) throws IOException {
	
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			input();

			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if(go[i][k] && go[k][j]) go[i][j] = true;
					}
				}
			}
			
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				int cnt = 0;
				
				for (int j = 1; j <= N; j++) {
					if(i == j) continue;
					
					if(go[i][j]) cnt++;
					if(go[j][i]) cnt++;
				}
				if(cnt == N-1) ans++; 
			}
			sb.append(String.format("#%d %d%n", tc, ans));
		}
		System.out.println(sb);
	}
}
