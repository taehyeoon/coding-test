package SWExpertAcademy;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-05 01:20
종료 시간 : 24-04-05 01:35
실행시간 : 170ms
메 모 리 : 35540KB
*/

public class SWEA_1249_보급로_D4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[][] map;
	static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	private static void input() throws IOException{

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
	}
	
	public static void main(String[] args) throws IOException {

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			int ans = -1;
			
			input();

			// (i, j, cost)
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

			pq.offer(new int[]{0, 0, 0});
			boolean[][] visited = new boolean[N][N];

			while (!pq.isEmpty()){

				int[] cur = pq.poll();
				int ci = cur[0], cj = cur[1], curCost = cur[2];

				if(ci == N-1 && cj == N-1) {
					ans = curCost;
					break;
				}

				visited[ci][cj] = true;

				for (int i = 0; i < 4; i++) {
					int ni = ci + dir[i][0];
					int nj = cj + dir[i][1];
					if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
					if(visited[ni][nj]) continue;

					pq.offer(new int[]{ni, nj, curCost + map[ni][nj]});
				}
			}

			sb.append(String.format("#%d %d%n", tc, ans));
		}

		System.out.println(sb);
	}
}
