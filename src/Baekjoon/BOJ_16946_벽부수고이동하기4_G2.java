package com.ssafy.coding;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-01 09:00
종료 시간 : 24-04-01 09:43
실행시간 : 724ms
메 모 리 : 152364KB
*/

public class BOJ_16946_벽부수고이동하기4_G2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int H, W;
	static int[][] map, adj, res;
	static List<Integer> adjCntList;
	static boolean[][] visited;
	
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0,-1}};
	
	private static void input() throws IOException{
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		adj = new int[H][W];
		res = new int[H][W];
		visited = new boolean[H][W];
		adjCntList = new ArrayList<Integer>();
		adjCntList.add(-99);
		
		for (int i = 0; i < H; i++) {
			String str = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
	}
	
	private static void findAdj(int si, int sj, int groupIdx) {
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {si, sj});
		visited[si][sj] = true;
		adj[si][sj] = groupIdx;
		int nearCnt = 1;
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			int ci = cur[0], cj = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int ni = ci + dir[i][0];
				int nj = cj + dir[i][1];
				
				if(ni < 0 || nj < 0 || ni >= H || nj >= W) continue;
				if(visited[ni][nj]) continue;
				visited[ni][nj] = true;
				if(map[ni][nj] == 1) continue;
				
				nearCnt++;
				adj[ni][nj] = groupIdx;
				q.add(new int[] {ni, nj});
			}
		}
		adjCntList.add(nearCnt);
	}
	
	
	public static void main(String[] args) throws IOException { 
		
		input();
		
		int groupIdx = 1;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(visited[i][j]) continue;
				
				if(map[i][j] == 1) continue;

				findAdj(i, j, groupIdx++);
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(adj[i][j] == 0) {

					int cellResult = 1;
					List<int[]> near = new ArrayList<int[]>();
					
					for (int d = 0; d < 4; d++) {
						int ni = i + dir[d][0];
						int nj = j + dir[d][1];
						
						if(ni < 0 || nj < 0 || ni >= H || nj >= W) continue;
						if(adj[ni][nj] == 0) continue; // 옆칸이 벽이면 skip

						// 이미 합친 cell이면 skip
						boolean alreadyMerged = false;
						for(int[] n : near) {
							if(adj[n[0]][n[1]] == adj[ni][nj]) {
								alreadyMerged = true;
								break;
							}
						}
						
						if(alreadyMerged) continue;
						
						near.add(new int[] {ni, nj});
						cellResult += adjCntList.get(adj[ni][nj]);
						cellResult %= 10;
					}
					
					res[i][j] = cellResult % 10;
				}
			}
		}
		
		// print
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				bw.write(Integer.toString(res[i][j]));
			}
			bw.write("\n");
		}
		
		bw.close();
	}
}
