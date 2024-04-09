package com.ssafy.coding;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-08 17:10
종료 시간 : 24-04-09 09:22
실행시간 : 264ms
메 모 리 : 25496KB
*/

public class BOJ_1915_가장큰정삼각형_G4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int H, W;
	static int[][] map, dp;
	
	static int[][] delta = {{1,0}, {-1,0}, {0, -1}, {0, 1}};
	private static void input() throws IOException{
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		dp = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			String str = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException { 
		
		input();
		
		// 아이디어 : 각 셀을 우하단으로 설정하고 만들 수 있는 최대 한 변의 길이를 
		// 2차원 배열에 저장하자
		for (int i = 0; i < H; i++) {
			dp[i][0] = map[i][0];
		}
		for (int i = 0; i < W; i++) {
			dp[0][i] = map[0][i];
		}
		
		for (int i = 1; i < H; i++) {
			for (int j = 1; j < W; j++) {
				// 현재 칸이 x이면 skip
				if(map[i][j] == 0) continue;
				
				// 좌, 상, 좌상 중 하나라도 x이면 현재 칸을 포함하는 사각형의 한변의 최대 사이즈는 1
				if(dp[i][j-1] == 0 || dp[i-1][j] == 0 || dp[i-1][j-1] == 0) {
					dp[i][j] = 1;
					continue;
				}
				
				// min(좌, 상) <= 좌상 인 경우는
				// min+1 사이즈의 정사각형 만들 수 있음
				int min = Math.min(dp[i][j-1],dp[i-1][j]);
				if(dp[i-1][j-1] >= min) min++;
				dp[i][j] = min;
			}
		}
		
		int max = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max* max);
	}
}
