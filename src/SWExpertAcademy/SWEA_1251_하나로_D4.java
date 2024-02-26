package coding.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
실행 시간 : 361ms
메모리 : 58132KB
 */
public class SWEA_1251_하나로_D4 {

	static class Vertex implements Comparable<Vertex>{
		int no;
		long x, y;
		double weight;

		public Vertex(int no, long x, long y, double weight) {
			super();
			this.no = no;
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	
	static double ans;
	static double[][] adjMatrix;
	static Vertex[] vertices;
	static double[] minEdge;
	static double E;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= TC; tc++) {
			sb.append("#"+tc+" ");
			int n = Integer.parseInt(br.readLine());
			adjMatrix = new double[n][n];
			vertices = new Vertex[n];
			minEdge = new double[n];
			visited = new boolean[n];
			
			StringTokenizer stx = new StringTokenizer(br.readLine());
			StringTokenizer sty = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				long x = Long.parseLong(stx.nextToken());
				long y = Long.parseLong(sty.nextToken());
				vertices[i] = new Vertex(i, x, y, Integer.MAX_VALUE);
			}
			E = Double.parseDouble(br.readLine());
			
			// 인접행렬 초기화
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					adjMatrix[i][j] = Math.pow(vertices[i].x-vertices[j].x, 2) + Math.pow(vertices[i].y-vertices[j].y, 2);
				}
			}

			
			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			
			Arrays.fill(minEdge, Double.MAX_VALUE);
			minEdge[0] = 0;
			pq.offer(new Vertex(0, 0, 0, 0));
			
			double result = 0; // 최소 신장 트리 비용
			int c = 0;
			while(!pq.isEmpty()) {
				Vertex minVertex = pq.poll();
				if(visited[minVertex.no]) continue;
				
				result += minVertex.weight * E;
				visited[minVertex.no] = true;
				if(++c == n) break;
				
				
				for(int i = 0; i < n; i++) {
					if(!visited[i] && adjMatrix[minVertex.no][i] != 0 && adjMatrix[minVertex.no][i] < minEdge[i]) {
						minEdge[i] = adjMatrix[minVertex.no][i];
						pq.offer(new Vertex(i, 0, 0, minEdge[i]));
					}
				}
			}
			
			long finalResult = Math.round(result);
			sb.append(finalResult + "\n");
		}
		
		System.out.println(sb.toString());
	}




}
