import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-25 17:20
종료 시간 : 24-04-25 17:44
실행 시간 : 84ms
메 모 리 : 20984KB
*/

public class BOJ_16929_TwoDots_G4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int H, W;
	static char[][] map;
	static boolean[][] visited;
	static char findChar;
	
	static int[][] delta = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	private static boolean dfs(int ci, int cj, int bi, int bj) {
		
		for(int i = 0; i < 4; i++) {
			int ni = ci + delta[i][0];
			int nj = cj + delta[i][1];
			
			if(ni < 0 || nj < 0 || ni >= H || nj >= W) continue;
			if(findChar != map[ni][nj]) continue;
			if(ni == bi && nj == bj) continue;
			if(visited[ni][nj]) return true;

			visited[ni][nj] = true;
			if(dfs(ni, nj, ci, cj)) return true;
			visited[ni][nj] = false;
		}
		
		return false;
		
	}
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());;
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		for(int i = 0; i < H; i++) {
			String str = br.readLine();
			for(int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		boolean hasCycle = false;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				visited = new boolean[H][W];
				findChar = map[i][j];
				visited[i][j] = true;
				if(dfs(i, j, -1, -1)) {
					hasCycle = true;
					break;
				}
			}
		}
		
		System.out.println(hasCycle ? "Yes" : "No");
	}
}
