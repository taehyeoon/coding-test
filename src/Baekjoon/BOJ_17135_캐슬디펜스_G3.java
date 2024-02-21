package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
실행시간 : 188ms
메모리 : 34156KB
*/

public class BOJ_17135_캐슬디펜스_G3 {

	static int deletedEnemy;
	static int N, M, D, ans, candidateAns;
	static int[][] originMap;
	static int[][] map;
	static int[] shooter = new int[3];
	static boolean[] isOccupied;
	static int[][] d = {{0,-1}, {-1,0}, {0,1}};
	
	

	public static void main(String[] args) throws IOException  {
		
		input();
		reset();
		combi(0, 0);
		System.out.println(ans);
	}

	
	
	private static void input() throws IOException{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		originMap = new int[N][M];
		isOccupied = new boolean[M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				originMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	
	private static void combi(int cnt, int start) {

		if(cnt == 3) {
			solve();
			reset();
			return;
		}
		
		for(int i = start; i < M; i++) {
			if(isOccupied[i]) continue;
			
			shooter[cnt] = i;
			combi(cnt+1, i+1);
		}
	}


	private static void reset() {
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			map[i] = Arrays.copyOf(originMap[i], M);
		}

		candidateAns = 0;
		deletedEnemy = 0;
	}


	private static void solve() {
		
		while(!isCleared()) {
			
			fire();
			moveForward();
		}

		ans = Math.max(ans, candidateAns);
	}


	private static void moveForward() {

		for(int r = N-1; r >= 1; r--) {
			for(int c = 0; c < M; c++) {
				map[r][c] = map[r-1][c];
			}
		}
		
		for(int c = 0; c < M; c++) {
			map[0][c] = 0;
		}
	}

	private static boolean isCleared() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0) return false;
			}
		}
		return true;
	}


	private static void fire() {
		
		int[][] target = new int[3][2];
		for(int i = 0; i < 3; i++) {
			target[i] = peekTarget(shooter[i]);
		}

		for(int i = 0; i < 3; i++) {
			if(target[i] != null) {
				
				if(map[target[i][0]][target[i][1]] == 1) {
					candidateAns++;
					map[target[i][0]][target[i][1]] = 0;
				}
				
			}
		}
	}

	private static int[] peekTarget(int shooterPos) {

		boolean[][] isVisited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {N-1, shooterPos});
		isVisited[N-1][shooterPos] = true;

		int[] cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			if(map[cur[0]][cur[1]] == 1) return cur;
			
			int ni, nj;
			for(int i = 0; i < 3; i++) {
				
				ni = cur[0] + d[i][0];
				nj = cur[1] + d[i][1];
				
				
				if(ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
				if(isVisited[ni][nj]) continue;
				if(getDis(ni, nj, shooterPos) > D) continue;
				
				
				isVisited[ni][nj] = true;
				q.add(new int[] {ni, nj});
			}
		}
		
		return null;
	}

	private static int getDis(int ni, int nj, int shooterPos) {

		return Math.abs(shooterPos - nj) + Math.abs(N - ni);
	}



}