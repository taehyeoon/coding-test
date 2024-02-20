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
시작 시간 : 24-02-20 15:30
종료 시간 : 24-02-20 16:30
실행시간 : 108ms
메 모 리 : 13672KB
*/

public class BOJ_2636_치즈_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    
    static int H, W, h, w;
    static int[][] map;
    static boolean[][] isVisited;
    static int totalCheeze, deletedCheeze;
    static int time;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = { 0, 0, 1,-1};
    private static void input() throws IOException {
    	st = new StringTokenizer(br.readLine());
    	H = Integer.parseInt(st.nextToken());
    	W = Integer.parseInt(st.nextToken());
    	
    	map = new int[H][W];
    	
    	
    	for(int i = 0; i < H; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < W; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			totalCheeze += map[i][j];
    		}
    	}
    }

    private static void solve() {
    	
    	// 제거된 치즈의 개수가 전체 치즈의 개수와 같을 때까지 반복
    	while(totalCheeze != deletedCheeze) {
    		isVisited = new boolean[H][W];
    		bfs();
    		
    		time++;
    	}
    	
		// BFS에서는 바뀔 치즈를 -t 값으로 수정
    	sb.append(time).append("\n");
    	
    	calcLastCheese();
    }
    
    private static void bfs() {
    	Queue<int[]> q = new LinkedList<int[]>();
    	q.add(new int[] {time, time});
    	isVisited[time][time] = true;
    	
    	int[] cur;
    	while(!q.isEmpty()) {
    		cur = q.poll();
    		
    		int ni, nj;
    		for(int i = 0; i < 4; i++) {
    			ni = cur[0]+dx[i]; nj = cur[1] + dy[i];
    			
    			if(ni < 0 || nj < 0 || ni >= H || nj >= W) continue;
    			if(isVisited[ni][nj]) continue;
    			if(map[ni][nj] == 1) { 
    				map[ni][nj] = -(time+1);
    				isVisited[ni][nj] = true;
    				deletedCheeze++;
    				continue; 
    			}
    			
    			isVisited[ni][nj] = true;
    			q.offer(new int[] {ni, nj});
    		}
    	}

	}

	private static void calcLastCheese() {
    	int lastCheeze = 0;
    	for(int i = 0; i < H; i++) {
    		for(int j = 0; j < W; j++) {
    			if(map[i][j] == -time) lastCheeze++;
    		}
    	}
    	sb.append(lastCheeze);
    }
    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}