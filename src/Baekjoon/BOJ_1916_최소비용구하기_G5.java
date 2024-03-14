package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-13 15:30
종료 시간 : 24-03-13 17:05
실행 시간 : 500ms
메 모 리 : 53760KB
*/

public class BOJ_1916_최소비용구하기_G5 {

	static class Node{
		int idx, cost;

		public Node(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
	}
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, S, E;
    static int[] dist;
    static List<Node>[] bus;

    private static void input() throws IOException {
    	N = Integer.parseInt(br.readLine());
    	M = Integer.parseInt(br.readLine());
    
    	dist = new int[N+1];
    	Arrays.fill(dist, Integer.MAX_VALUE);
    	
    	bus = new ArrayList[N+1];
    	for(int i = 1; i <= N; i++) {
    		bus[i] = new ArrayList<Node>();
    	}
    	for(int i = 1; i <= M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int s = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		int w = Integer.parseInt(st.nextToken());
    		bus[s].add(new Node(e, w));
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	S = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
    }
    public static void main(String[] args) throws IOException {
    	input();
    	
    	PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
    	q.offer(new Node(S, 0));
    	dist[S] = 0;

    	
    	while(!q.isEmpty()) {
    		Node cur = q.poll();
    		
    		if(cur.idx == E) break;
    		
    		if(dist[cur.idx] < cur.cost) {
    			continue;
    		}
    		
    		for(int i = 0; i < bus[cur.idx].size(); i++) {
    			Node nextNode = bus[cur.idx].get(i);
    			
    			if(dist[nextNode.idx] > cur.cost + nextNode.cost) {
    				dist[nextNode.idx] = cur.cost + nextNode.cost;
    				q.offer(new Node(nextNode.idx, dist[nextNode.idx]));
    			}
    		}
    		
    	}
    	
    	System.out.println(dist[E]);
    	
    }
}