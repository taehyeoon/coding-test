package coding.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
실행시간 : 199ms
메모리 : 33.3MB
*/

public class JL_1661_미로탈출로봇 {

	static int[][] map;
	static int scol, srow, ecol, erow;
	static int rowN, colN;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = { 0, 0,-1, 1};
	static int[][] best;
	static boolean[][] isVisited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		colN = Integer.parseInt(st.nextToken());
		rowN = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		scol = Integer.parseInt(st.nextToken()) - 1;
		srow = Integer.parseInt(st.nextToken()) - 1;
		ecol = Integer.parseInt(st.nextToken()) - 1;
		erow = Integer.parseInt(st.nextToken()) - 1;
		
		map = new int[rowN][colN];
		
		for(int i = 0; i < rowN; i++) {
			String line = br.readLine();
			for(int j = 0; j < colN; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
//		bfs();
        isVisited = new boolean[rowN][colN];
		best = new int[rowN][colN];
		for(int i = 0; i < rowN; i++) {
			Arrays.fill(best[i], Integer.MAX_VALUE);
		}
		
		isVisited[srow][scol] = true;
		dfs(srow, scol, 0);
		
		System.out.println(best[erow][ecol]);
		
	}
	private static void dfs(int curR, int curC, int cnt) {

		if(curR == erow && curC == ecol) {
			best[curR][curC] = Math.min(best[curR][curC], cnt);
			return;
		}
		
		int nr, nc;
		for(int i = 0; i < 4; i++) {
			nr = curR + dr[i];
			nc = curC + dc[i];
			
			
			
			if(nr < 0 || nc < 0 || nr >= rowN || nc >= colN) continue;
			if(map[nr][nc]!=0) continue;
			if(isVisited[nr][nc]) continue;
			if(cnt+1 >= best[nr][nc]) continue;

			
			
			best[nr][nc] = cnt+1;
			isVisited[nr][nc] = true;	
			
			dfs(nr, nc, cnt+1);
			isVisited[nr][nc] = false;
		}
		
	}
	
	private static void bfs() {

		ArrayDeque<int[]> queue = new ArrayDeque<>();
		map[srow][scol] = 1; // 방문표시
		queue.offer(new int[] {srow, scol});
		
		int r, c, nr, nc, count;
		int[] temp;
		top:
		while(!queue.isEmpty()) {
			temp = queue.poll();
			r = temp[0];
			c = temp[1];
			count = map[r][c];
			
			// 인접 노드 방문
			for(int i = 0; i < 4; i++) {
				nr = r+dr[i];
				nc = c+dc[i];
				
				// 경계, 갈 수 있는 길인지 체크
				if(nr > -1 && nr <rowN && nc >-1 && nc < colN && map[nr][nc] == 0) {
					map[nr][nc] = count+1; // 방문체크 및 이동거리 작성
					if(nr == erow && nc == ecol) { // 도착
						break top;
					}
					queue.offer(new int[] {nr, nc});
				}
			}
		}
		System.out.println(map[erow][ecol] - 1); // 시작지점에 방문체크를 위해서 1로 시작
		
		
	}
	
}
