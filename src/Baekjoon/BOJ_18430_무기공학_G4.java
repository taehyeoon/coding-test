package com.ssafy.coding;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-01 10:05
종료 시간 : 24-04-01 10:40
실행시간 : 352ms
메 모 리 : 24212KB
*/

public class BOJ_18430_무기공학_G4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int H, W, ans;
	static int[][] originMap, map;
	
	static int[][][] shape = {
			{{0,-1}, {1,0}},
			{{0,-1}, {-1,0}},
			{{-1,0}, {0,1}},
			{{1,0}, {0,1}},
			};
	
	private static void input() throws IOException{
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		originMap = new int[H][W];
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				originMap[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = originMap[i][j];
			}
		}
	}
	
	private static boolean isPossible(int ci, int cj, int s) {
		
		for (int i = 0; i < 2; i++) {
			int ni = ci + shape[s][i][0];
			int nj = cj + shape[s][i][1];
			
			if(ni < 0 || nj < 0 || ni >= H || nj >= W) return false;
			if(map[ni][nj] == -1) return false;
		}
		
		return true;
	}
	
	private static int setWeapon(int ci, int cj, int s, boolean use) {
		
		int value = 2* originMap[ci][cj];
		
		if(use) map[ci][cj] = -1;
		else map[ci][cj] = originMap[ci][cj];
		
		for (int i = 0; i < 2; i++) {
			int ni = ci + shape[s][i][0];
			int nj = cj + shape[s][i][1];
			
			map[ni][nj] = use ? -1 : originMap[ni][nj];
			value += originMap[ni][nj];
		}
		
		return value;
	}
	
	private static void dfs(int ci, int cj, int cost) {
		
		// 마지막까지 전부 탐색한 경우
		if(ci == H-1 && cj == W) {
			ans = Math.max(ans, cost);
			return;
		}
			
		// 다음줄로 이동
		if(cj == W) {
			dfs(ci+1, 0, cost);
			return;
		}
		
		// 이미 무기를 만든 칸 skip
		if(map[ci][cj] == -1) {
			dfs(ci, cj+1, cost);
			return;
		}
		
		// 4가지 모양에 대해 탐색
		for (int s = 0; s < 4; s++) {
			if(isPossible(ci, cj, s)) {
				int value = setWeapon(ci, cj, s, true);
				dfs(ci, cj+1, cost+value);
				setWeapon(ci, cj, s, false);
			}
		}
		
		// 아무모양도 만들 수 없는 경우, 다음 칸으로 이동
		dfs(ci, cj+1, cost);
		
	}
	
	public static void main(String[] args) throws IOException { 
		
		input();
		
		dfs(0,0,0);
		
		System.out.println(ans);
	}
}
