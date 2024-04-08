package com.ssafy.coding;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-08 14:00
종료 시간 : 24-04-08 16:42
실행시간 : 208ms
메 모 리 : 29792KB
*/

public class BOJ_17142_연구소3_G3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, emptyCnt, ans = Integer.MAX_VALUE;
	static int[][] map;
	static List<int[]> inActiveViruses;
	static boolean[] selected;
	
	static int[][] delta = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	
	private static void input() throws IOException{
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		inActiveViruses = new ArrayList<int[]>();
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) inActiveViruses.add(new int[] {i, j}); 
				if(map[i][j] == 0) emptyCnt++;
			}
		}
		
		selected = new boolean[inActiveViruses.size()];
	}
	
	private static void spread(int[] virusIndices) {
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[][] visited = new boolean[N][N];
		
		for (int i = 0; i < virusIndices.length; i++) {
			int ci = inActiveViruses.get(virusIndices[i])[0];
			int cj = inActiveViruses.get(virusIndices[i])[1];
			q.offer(new int[] {ci, cj});
			visited[ci][cj] = true;
		}
		int time = 0;
		int emptyBlock = emptyCnt;
		while(!q.isEmpty()) {
			
			int qSize = q.size();
			if(emptyBlock == 0) break;
			if(time > ans) return;
			time++;
			
			for(int iter = 0; iter < qSize; iter++) {
				int[] cur = q.poll();
				int ci = cur[0], cj = cur[1];
				
				for (int i = 0; i < 4; i++) {
					int ni = ci + delta[i][0];
					int nj = cj + delta[i][1];
					
					if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
					if(visited[ni][nj]) continue;
					if(map[ni][nj] == 1) continue;
					
					visited[ni][nj] = true;
					if(map[ni][nj] == 0) emptyBlock--;
					q.add(new int[] {ni, nj});
				}
			}
		}
		
		if(emptyBlock == 0)
			ans = Math.min(ans, time);
	}
	
	private static void combi(int cnt, int start) {
		
		if(cnt == M) {
			int[] virusIndices = new int[M];
			int idx = 0;
			for (int i = 0; i < inActiveViruses.size(); i++) {
				if(selected[i]) virusIndices[idx++] = i;
			}
			spread(virusIndices);
			return;
		}
		
		for (int i = start; i < inActiveViruses.size(); i++) {
			if(selected[i]) continue;
			
			selected[i] = true;
			combi(cnt+1, i);
			selected[i] = false;
		}
	}

	public static void main(String[] args) throws IOException { 
		
		input();
		
		combi(0, 0);
		
		if(ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
	}
}
