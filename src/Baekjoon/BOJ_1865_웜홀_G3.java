package coding.baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-27 21:10
종료 시간 : 24-03-27 12:00
실행 시간 : 2748ms
메 모 리 : 52888KB
*/

public class BOJ_1865_웜홀_G3 {

	static class Edge {
		
		int s, e, t;

		public Edge(int s, int e, int t) {
			super();
			this.s = s;
			this.e = e;
			this.t = t;
		}
		
		@Override
			public boolean equals(Object obj) {
				Edge e2 = (Edge) obj;
				return this.s == e2.s && this.e == e2.e;
			}
	}
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int TC;
    static int N, M, W;
    static int[] dist;
    static ArrayList<Edge> edges;

    static final int INF = Integer.MAX_VALUE;
    private static void reset() throws IOException { 
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	W = Integer.parseInt(st.nextToken());
    	
    	dist = new int[N+1];
    	
    	edges = new ArrayList<>();
    	
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int s = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		int t = Integer.parseInt(st.nextToken());
    		
    		Edge stoe = new Edge(s, e, t);
    		Edge etos = new Edge(e, s, t);
    		boolean added = false;
    		for(int j = 0; j < edges.size(); j++) {
    			if(edges.get(j).equals(stoe)) {
    				if(edges.get(j).t > t) {
    					edges.get(j).t = t;
    				}
    				added = true;
    				break;
    			}
    		}
    		if(!added) edges.add(stoe);
    		added = false;
    		for(int j = 0; j < edges.size(); j++) {
    			if(edges.get(j).equals(etos)) {
    				if(edges.get(j).t > t) {
    					edges.get(j).t = t;
    				}
    				added = true;
    				break;
    			}
    		}
    		if(!added) edges.add(etos);
    	}
    	
    	for(int i = 0; i < W; i++) {
    		st = new StringTokenizer(br.readLine());
    		int s = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		int t = Integer.parseInt(st.nextToken());
    		edges.add(new Edge(s, e, -t));
    	}
    }
    
    private static boolean bellman(int start) {
    	
    	Arrays.fill(dist, INF);
    	dist[start] = 0;
    	
    	for(int i = 0; i < N; i++) {
    		boolean ch  = false;
    		for(int j = 0; j < edges.size(); j++) {
    			Edge edge = edges.get(j);
    			
    			if(dist[edge.s] != INF && dist[edge.s] + edge.t < dist[edge.e]) {
    				dist[edge.e] = dist[edge.s] + edge.t;
    				ch  = true;
    			}
    		}
    		
    		if(!ch) break;
    	}
    	
    	for(int i = 0; i < edges.size(); i++) {
    		Edge edge = edges.get(i);
    		
    		if(dist[edge.s] != INF && dist[edge.e] > dist[edge.s] + edge.t) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    public static void main(String[] args) throws IOException {
    	StringBuilder sb = new StringBuilder();
    	TC = Integer.parseInt(br.readLine());
    	
    	for(int tc = 0; tc < TC; tc++) {
    		reset();
    		boolean result = false; 
    		for(int i = 1; i <= N; i++) {
    			if(bellman(i)) {
    				result = true;
    				break;
    			}
    		}
    		String str = result ? "YES" : "NO";
    		sb.append(str).append("\n");
    	}
    	System.out.println(sb);
    }
}