package coding.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-23
종료 시간 : 24-02-23
실행시간 : 84ms
메 모 리 : 11860KB
*/

public class BOJ_17472_다리만들기2_G1 {

	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		public Edge(int start, int end, int weight) {
			super();
			this.from = start;
			this.to = end;
			this.weight = weight;
		}
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    
    static int N, M;
    static int islandNum = 0, result;
    static int[][] map;
    static int[][] edge;
    static int[] parents;
    static ArrayList<Edge> edgeList = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    private static void input() throws IOException {
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map= new int[N][M];
    	
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < M; j++) {
    			int temp = Integer.parseInt(st.nextToken());
    			map[i][j] = temp == 1 ? -1 : 0;
    		}
    	}
    	
    }
    
    private static void kruskal() {
    	for(int i = 1; i <= islandNum; i++) {
    		for(int j = i+1; j <= islandNum; j++) {
    			if(edge[i][j] == 0) continue;
    			edgeList.add(new Edge(i, j, edge[i][j]));
    		}
    	}
    	
    	Collections.sort(edgeList);
    	
    	int count = 0;
    	for(Edge e : edgeList) {
    		if(!union(e.from, e.to)) continue;
    		
    		result += e.weight;
    		if(++count == islandNum-1) break;
    	}
    	
    	if(result == 0 || count != islandNum -1) result = -1;
	}

	private static void makeSet() {
		parents = new int[islandNum+1];
		for (int i = 1; i <= islandNum; i++) {
			parents[i] = i;
		}
	}
    
   
    private static int find(int v) {
    	if(parents[v] == v) return v;
    	
    	return parents[v] = find(parents[v]);
    }

   
    private static boolean union(int a, int b) {
    	int aRoot = find(a);
    	int bRoot = find(b);
    	
    	if(aRoot == bRoot) return false;
    	parents[bRoot] = aRoot;
    	return true;
    }
    
	
    private static void makeBridge() {
    	edge = new int[islandNum+1][islandNum+1];
    	for(int i = 1; i <= islandNum; i++)
    		Arrays.fill(edge[i], Integer.MAX_VALUE);
    	
    
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    		
    			if(map[i][j] == 0) continue;
    			makeSingleBridge(i, j, map[i][j]);
    		}
    	}
    	
    	for(int i = 1; i <= islandNum; i++) {
    		for(int j = 1; j <= islandNum; j++) {
    			if(edge[i][j] == Integer.MAX_VALUE) edge[i][j] = 0;
    		}
    	}
	}

	private static void makeSingleBridge(int idxI, int idxJ, int island) {
    
    	top:
    	for(int i = 0; i < 4; i++) {
    		int bridge = -1;
    		int ni = idxI;
    		int nj = idxJ;
    		
    		do {
    			bridge++;
    			ni += dx[i];
    			nj += dy[i];
    			if(ni < 0 || nj < 0 || ni >= N || nj >= M) continue top;
    		}while(map[ni][nj] == 0);
    		
    		int target = map[ni][nj];
    		if(target == island) continue;
    		
    		if(bridge > 1 && bridge < edge[island][target]) {
    			edge[island][target] = bridge;
    			edge[target][island] = bridge;
    		}
    	}
	}


	private static void searchIsland() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != -1) continue;
				islandNum++;
				bfs(i, j);
			}
		}
	}

	private static void bfs(int idxI, int idxJ) {

		boolean[][] isVisited = new boolean[N][M];
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {idxI, idxJ});
		isVisited[idxI][idxJ] = true;
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			map[cur[0]][cur[1]] = islandNum;
			
			for(int i = 0; i < 4; i++) {
				int ni = cur[0] + dx[i];
				int nj = cur[1] + dy[i];
				
				if(ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
				if(isVisited[ni][nj]) continue;
				if(map[ni][nj] == 0) continue;
				
				isVisited[ni][nj] = true;
				q.offer(new int[] {ni, nj});
			}
		}
	}
	
	public static void main(String[] args) throws IOException {

        input();
        
    	searchIsland();
    	makeBridge();
    	makeSet();
    	kruskal();
    	
        bw.write(result + "");
        bw.close();
        br.close();
    }
}