package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-17 21:30
종료 시간 : 24-02-17 22:45
실행시간 : 812ms / 실패
메 모 리 : 118924KB

고려사항
다익스트라 알고리즘을 사용하여 풀이
*/

public class BOJ_1753_최단경로_G4 {

    static class Node{
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;


    static int V, E, K;
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        // 엣지 초기화
        graph = new ArrayList<>();
        for (int i = 0; i < V+1; i++){
            graph.add(new ArrayList<>());
        }

        // 엣지 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, cost));
        }

        // 다익스트라 알고리즘 초기화
        dist = new int[V+1]; // 최소 비용을 저장할 배열
        Arrays.fill(dist, Integer.MAX_VALUE);
    }

    private static void dijkstra(){

        // 방문한 노드 중 최단 거리인 노드를 선택하기 위한 큐
        PriorityQueue<Node> q = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));

        q.offer(new Node(K, 0));
        dist[K] = 0;
        while (!q.isEmpty()){
            Node curNode = q.poll();

            if(dist[curNode.idx] < curNode.cost) continue;

            for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
                // 현재 노드와 인접한 노드 가져오기
                Node nextNode = graph.get(curNode.idx).get(i);

                // 기존에 저장된 최단거리보다 현재 노드를 거져 가는 경우에 더 짧은 경우에만 큐에 넣는다
                if(dist[nextNode.idx] > curNode.cost + nextNode.cost){
                    dist[nextNode.idx] = curNode.cost + nextNode.cost;
                    q.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }

    }

    private static void print() throws IOException {
        for (int i = 1; i <= V; i++) {
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF");
            else sb.append(dist[i]);
            sb.append("\n");
        }
        bw.write(sb.toString());
    }
    public static void main(String[] args) throws IOException {

        input();
        dijkstra();
        print();

        br.close();
        bw.close();
    }
}
