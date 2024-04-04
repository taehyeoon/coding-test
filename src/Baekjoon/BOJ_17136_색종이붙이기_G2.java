package com.ssafy.coding;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-04 12:00
종료 시간 : 24-04-04 16:20
실행 시간 : 216ms / 실패
메 모 리 : 20900KB
*/

public class BOJ_17136_색종이붙이기_G2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int ans = Integer.MAX_VALUE;
	static int[] remain = {0, 5, 5, 5, 5, 5};
	static int[][] map;
	
	private static void input() throws IOException{
		
		
		map = new int[10][10];
		
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	private static void dfs(int x, int y, int cnt) {
		
		if(x >= 9 && y > 9) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		if(ans <= cnt) return;
		
		if(y > 9) {
			dfs(x+1, 0, cnt);
			return;
		}
		
		if(map[x][y] == 1) {
			
			for (int i = 5; i >= 1; i--) {
				if(remain[i] > 0 && canAttach(x,y,i)) {
					attach(x,y,i,0);
					remain[i]--;
					dfs(x,y+1,cnt+1);
					attach(x,y,i,1);
					remain[i]++;
					
				}
			}
		}else {
			dfs(x,y+1,cnt);
		}
	}
	
	private static void attach(int x, int y, int size, int state) {

		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				map[i][j] = state;
			}
		}
	}

	private static boolean canAttach(int x, int y, int size) {

		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if(i < 0 || j < 0 || i >= 10 || j >= 10) return false;
				
				if(map[i][j] != 1) return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException { 
		input();
		
		dfs(0, 0, 0);
		
		if(ans == Integer.MAX_VALUE) ans = -1;
		
		System.out.println(ans);
	}
}
