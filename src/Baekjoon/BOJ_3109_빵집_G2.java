package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-01-31 11:50
종료 시간 : 24-01-31 12:10
실행 시간 : 324ms
메 모 리 : 36912KB 
*/

public class BOJ_3109_빵집_G2 {

	static int R, C, ans;
	static char[][] map;
	static int[] d = {-1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String line = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		

		for(int i = 0; i < R; i++) {
			dfs(i, 0);
		}
		
		System.out.println(ans);
	}
	
	private static boolean dfs(int r, int c) {

		if(c == C-1) {
			ans++;
			return true;
		}
		
		map[r][c] = 'x';
		
		int nr, nc;
		for(int i = 0; i < 3; i++) {
			nr = r + d[i];
			nc = c + 1;
			
			if(nr < 0 || nr >= R || nc >= C) continue;
			if(map[nr][nc] == 'x') continue;
			
			if(dfs(nr, nc)) return true;
		}
			
		return false;
	}
}