package com.ssafy.coding;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-02 12:30
종료 시간 : 24-04-02 13:50
실행 시간 : 252ms
메 모 리 : 24876KB
*/

public class BOJ_4485_녹색옷입은애가젤다지_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, ans;
    static int[][] map;
    
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0,  0,-1, 1};
    
    
    public static void main(String[] args) throws IOException {

    	StringBuilder sb = new StringBuilder();
    	int tc = 1;
    	N = Integer.parseInt(br.readLine());
    	while(N != 0) {
    		map = new int[N][N];
    		for(int i = 0; i < N ; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j = 0; j < N; j++) {
    				map[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		// 다익스트라
    		int ans = 0;
    		boolean[][] visit = new boolean[N][N];
    		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				
				}
			});
    		pq.offer(new int[] {0, 0, map[0][0]});
    		
    		Dijk:
    		while(!pq.isEmpty()) {
    			
    			int[] cur = pq.poll();
    			int ci = cur[0], cj = cur[1], curVal = cur[2];
    			visit[ci][cj] = true;
    			
    			for(int i = 0; i < 4; i++) {
    				int ni = ci + di[i];
    				int nj = cj + dj[i];
    				
    				if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
    				if(visit[ni][nj]) continue;
    				
    				if(ni == N-1 && nj == N-1) {
    					ans = curVal + map[ni][nj];
    					break Dijk;
    				}
    				
    				pq.offer(new int[] {ni, nj, curVal + map[ni][nj]});
    			}
    		}
    		
    		sb.append(String.format("Problem %d: %d%n", tc++, ans));
    		N = Integer.parseInt(br.readLine());
    	}
    	System.out.println(sb);
    }
}