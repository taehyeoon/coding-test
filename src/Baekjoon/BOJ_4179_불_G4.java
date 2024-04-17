import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-17 14:10
종료 시간 : 24-04-17 15:30
실행 시간 : 436ms
메 모 리 : 46156KB
*/

public class BOJ_4179_불_G4 {

	static int R, C;
	static char[][] map;
	static int[][] delta = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	static boolean[][] fireVisited;
	static boolean[][] moveVisited;
	
	static Queue<int[]> fires = new ArrayDeque<>();
	static Queue<int[]> moves = new ArrayDeque<>();
	
	private static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		fireVisited = new boolean[R][C];
		moveVisited = new boolean[R][C];
		
		map = new char[R][C];
		for(int i = 0; i < R; i++) {
			String line = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'J') {
					moves.add(new int[] {i, j});
					moveVisited[i][j] = true;
				}
				if(map[i][j] == 'F') {
					fires.add(new int[] {i, j});
					fireVisited[i][j] = true;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		input();
		
		int time = 0;
		boolean escape = false;
		
		int[] start = moves.peek();
		
		if(start[0] == 0 || start[1] == 0 || start[0] == R-1 || start[1] == C-1) {
			System.out.println(1);
			return;
		}
		
		
		Find:
		while(!moves.isEmpty()) {
			time++;
			
			// 불 확산
			int fireSize = fires.size();
			for(int iter = 0; iter < fireSize; iter++) {
				
				int[] cur = fires.poll();
				int ci = cur[0], cj = cur[1];
				
				for(int i = 0 ; i < 4; i ++) {
					int ni = ci + delta[i][0];
					int nj = cj + delta[i][1];
					
					if(ni < 0 || nj < 0 || ni >= R || nj >= C) continue;
					
					// 불이 이미 퍼진 곳만 피하면 됨
					if(fireVisited[ni][nj]) continue;
					if(map[ni][nj] == '#') continue;
					
					fireVisited[ni][nj] = true;
					map[ni][nj] = 'F';
					fires.add(new int[] {ni, nj});
				}
			}
				
			int moveSize = moves.size();
			for(int iter = 0; iter < moveSize; iter++) {
				
				int[] cur = moves.poll();
				int ci = cur[0], cj = cur[1];
				
				for(int i = 0 ; i < 4; i ++) {
					int ni = ci + delta[i][0];
					int nj = cj + delta[i][1];
					
					if(moveVisited[ni][nj]) continue;
					if(map[ni][nj] == '.') {
						moveVisited[ni][nj] = true;
						moves.add(new int[] {ni, nj});
							
						if(ni == 0 || nj == 0 || ni == R-1 || nj == C-1) {
							time++;
							escape = true;
							break Find;
						}
					}
				}
			}
		}
		
		if(escape) {
			System.out.println(time);
		}else {
			System.out.println("IMPOSSIBLE");
		}
		
	}
}
