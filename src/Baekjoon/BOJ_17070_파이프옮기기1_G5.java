package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-21 14:45
종료 시간 : 24-02-21 15:20
실행시간 : 260ms
메 모 리 : 16052KB
*/


public class BOJ_17070_파이프옮기기1_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    
    static int N, ans;
    static int[][] map;
    static int state = 0; 
    private static void input() throws IOException {
    	N = Integer.parseInt(br.readLine());
    	
    	map = new int[N][N];
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    }

    private static void solve() {
    	
    	dfs(0, 0, 1);
    	
    	sb.append(ans);
    }
    

    // state 가로 : 0, 세로 : 1, 대각 : 2
	private static void dfs(int state, int idxI, int idxJ) {

		if(idxI == N-1 && idxJ == N-1) {
			ans++;
			return;
		}
		
		if(!isValid(idxI, idxJ)) return;
		
		// 대각은 무조건 가능
		if(isValid(idxI, idxJ+1) && isValid(idxI+1, idxJ) && isValid(idxI+1, idxJ+1))
			dfs(2, idxI+1, idxJ+1); // 대각
	
		// 가로
		if(state == 0) {
			if(isValid(idxI, idxJ+1)) 
				dfs(0, idxI, idxJ+1); // 가로
		// 세로
		}else if(state == 1) {
			if(isValid(idxI+1, idxJ))
				dfs(1, idxI+1, idxJ); // 세로
		// 대각
		}else {
			if(isValid(idxI, idxJ+1)) 
				dfs(0, idxI, idxJ+1); // 가로
			if(isValid(idxI+1, idxJ))
				dfs(1, idxI+1, idxJ); // 세로
		}
	}
	
	private static boolean isValid(int i, int j) {
		return i >= 0 && j >= 0 && i < N && j < N && map[i][j] != 1;
	}

	public static void main(String[] args) throws IOException {

        input();
        solve();
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}