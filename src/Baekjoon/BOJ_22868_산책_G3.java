package coding.baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-25:09:15
종료 시간 : 24-03-25 10:32
실행 시간 : 336ms
메 모 리 : 30724KB
*/

public class BOJ_22868_산책_G3 {

	static class Node {
		boolean visited;
		List<Integer> route = new ArrayList<>();
	}
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, S, E;
    static PriorityQueue<Integer>[] adj;
    static Node[] nodes;
    
    private static void input() throws IOException{
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	nodes = new Node[N+1];
    	adj = new PriorityQueue[N+1];
    	for(int i = 1; i <= N; i++) {
    		adj[i] = new PriorityQueue<>();
    		nodes[i] = new Node();
    	}
    	
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		adj[a].offer(b);
    		adj[b].offer(a);
    	}
    	st = new StringTokenizer(br.readLine());
    	S = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
    }
    
    public static void main(String[] args) throws IOException {
 
    	input();
    	
    	Queue<Integer> q = new ArrayDeque<>();
    	q.offer(S);
    	
    	// S -> E
    	ToEnd:
    	while(!q.isEmpty()) {
    		
    		// 같은 depth 만큼씩 BFS 탐색
    		int size = q.size();
    		for(int iter = 0; iter < size; iter++) {
    			
    			int next = q.poll();
    			
    			PriorityQueue<Integer> tempPQ = new PriorityQueue<>(adj[next]); 
    			while(!tempPQ.isEmpty()) {
    				int adjNodeIdx = tempPQ.poll();
    				if(nodes[adjNodeIdx].visited) continue;
    				nodes[adjNodeIdx].visited = true;
    				
    				// 각 노드에 해당 노드까지 거쳐온 경로 저장
    				List<Integer> route = new ArrayList<>(nodes[next].route);
    				route.add(adjNodeIdx);
    				nodes[adjNodeIdx].route = route;
    				
    				q.offer(adjNodeIdx);
    				// 도착지 만날 시 종료
    				if(adjNodeIdx == E) {    					
    					break ToEnd;
    				}
    			}
    		}
    	}
    	
    	// s -> E로 가는 동안 방문하지 않은 노드 visit false 처리
    	for(int i = 1; i <= N; i++) {
    		if(!nodes[E].route.contains(i)) {
    			nodes[i].visited = false;
    		}
    	}
    	
    	q = new ArrayDeque<>();
    	q.offer(E);
    	
    	// E -> S (S->E과정 거꾸로 반복)
    	ToStart:
    	while(!q.isEmpty()) {
    		
    		int size = q.size();
    		for(int iter = 0; iter < size; iter++) {
    			
    			int next = q.poll();
    			
    			PriorityQueue<Integer> tempPQ = new PriorityQueue<>(adj[next]); 
    			while(!tempPQ.isEmpty()) {
    				int adjNodeIdx = tempPQ.poll();
    				if(nodes[adjNodeIdx].visited) continue;
    				nodes[adjNodeIdx].visited = true;
    				
    				List<Integer> route = new ArrayList<>(nodes[next].route);
    				route.add(adjNodeIdx);
    				nodes[adjNodeIdx].route = route;
    				
    				q.offer(adjNodeIdx);
    				if(adjNodeIdx == S) {    					
    					break ToStart;
    				}
    			}
    			
    		}
    	}
    	
    	System.out.println(nodes[S].route.size());
    }
    
}
