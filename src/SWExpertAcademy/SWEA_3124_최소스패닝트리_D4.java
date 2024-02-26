package coding.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
실행 시간 : 1928ms
메모리 : 120724KB
 */
public class SWEA_3124_최소스패닝트리_D4 {

	static class Edge implements Comparable<Edge>{
		int a, b;
		long w;

		public Edge(int a, int b, long w) {
			super();
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w > o.w ? 1 : -1;
		}
	}
	
	
	static int TC, V, E;
	static Edge[] edges;
	
	static int[] parents;
	
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
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edges = new Edge[E];
			parents = new int[V+1];
			for(int i = 1; i <= V; i++) parents[i] = i;
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(a, b, w);
			}
			
			Arrays.sort(edges);
			
			int cnt = 0;
			long ans = 0;
			for(Edge e : edges) {
				if(!union(e.a, e.b)) continue;
				
				ans += e.w;
				if(++cnt == V-1) break;
			}
			
			System.out.println("#"+tc + " " +  ans);
		}
	}
}
