package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-13 20:20
종료 시간 : 24-03-13 20:55
실행 시간 : 556ms
메 모 리 : 46728KB
*/

public class BOJ_1238_파티_G3 {

	static class Node{
		int idx;
		int cost; // 시작 지점에서 idx 노드까지 거리

		public Node(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
	}
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, X;
    static int[] p2h, h2p;
    static List<Node>[] edge;

    private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		h2p = new int[N+1];
		p2h = new int[N+1];

		edge = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			edge[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edge[s].add(new Node(e, w));
		}
    }

	private static void findP2H(){

		Arrays.fill(p2h, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));

		pq.offer(new Node(X, 0));
		p2h[X] = 0;


		while (!pq.isEmpty()) {

			Node cur = pq.poll();

			// cur을 통해 구한 경로 비용이 기존의 경로 비용보다 비싼 경우, 무시
			if(cur.cost > p2h[cur.idx]) continue;

			for (int i = 0; i < edge[cur.idx].size(); i++) {
				Node next = edge[cur.idx].get(i);

				if(next.cost + cur.cost < p2h[next.idx]){
					p2h[next.idx] = next.cost + cur.cost;
					pq.offer(new Node(next.idx, p2h[next.idx]));
				}
			}
		}
	}

	private static void findH2P(int s){
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));

		pq.offer(new Node(s, 0));
		dist[s] = 0;


		while (!pq.isEmpty()) {

			Node cur = pq.poll();

			if(cur.idx == X) break;

			// cur을 통해 구한 경로 비용이 기존의 경로 비용보다 비싼 경우, 무시
			if(cur.cost > dist[cur.idx]) continue;

			for (int i = 0; i < edge[cur.idx].size(); i++) {
				Node next = edge[cur.idx].get(i);

				if(next.cost + cur.cost < dist[next.idx]){
					dist[next.idx] = next.cost + cur.cost;
					pq.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}

		h2p[s] = dist[X];
	}
    public static void main(String[] args) throws IOException {
    	input();

		findP2H();

		for (int i = 1; i < N+1; i++) {
			if(i == X) continue;

			findH2P(i);
		}

		int max = 0;
		for (int i = 1; i < N+1; i++) {
			max = Math.max(max, p2h[i] + h2p[i]);
		}

		System.out.println(max);
    }
}