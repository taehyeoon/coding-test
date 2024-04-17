import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-17 16:00
종료 시간 : 24-04-17 17:17
실행 시간 : 92ms
메 모 리 : 13208KB
*/

public class BOJ_14391_종이조각_G3 {

	static int H, W, ans;
	static int[][] map;
	static boolean[][] used;
	
	private static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		used = new boolean[H][W];
		map = new int[H][W];
		for(int i = 0; i < H; i++) {
			String line = br.readLine();
			for(int j = 0; j < W; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
	}
	
	
	private static void dfs(int ci, int cj, int sum) {
		
		// 결과 계산
		if(ci == H-1 && cj == W) {
			ans = Math.max(ans, sum);
			return;
		}

		// 오른쪽 끝 도달
		if(cj >= W) {
			dfs(ci+1, 0, sum);
			return;
		}
		
		// 이미 방문한 칸 스킵
		if(used[ci][cj]) {
			dfs(ci, cj+1, sum);
			return;
		}
		
		// 1칸만 차지
		used[ci][cj] = true;
		dfs(ci, cj+1, sum + map[ci][cj]);
		
		
		// 가로칸 차지
		int blockValue = map[ci][cj];
		int checkEnd=0;
		for(int i = 1; i < W; i++) {
			if(cj+i == W) break;
			if(used[ci][cj+i]) break;
			
			checkEnd = i;
			used[ci][cj+i] = true;
			blockValue = blockValue*10 + map[ci][cj+i];
			dfs(ci, cj+i+1, sum + blockValue);
		}
		
		// 원상복구
		for(int i = 1; i <= checkEnd; i++) {
			used[ci][cj+i] = false;
		}
		
		
		// 가로칸 차지
		blockValue = map[ci][cj];
		checkEnd = 0;
		for(int i = 1; i < H; i++) {
			if(ci+i == H) break;
			if(used[ci+i][cj]) break;
			
			checkEnd = i;
			used[ci+i][cj] = true;
			blockValue = blockValue*10 + map[ci+i][cj];
			dfs(ci, cj+1, sum + blockValue);
		}
		
		// 원상복구
		for(int i = 1; i <= checkEnd; i++) {
			used[ci+i][cj] = false;
		}
		
		used[ci][cj] = false;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		input();

		dfs(0, 0, 0);
		
		System.out.println(ans);
	}
}
