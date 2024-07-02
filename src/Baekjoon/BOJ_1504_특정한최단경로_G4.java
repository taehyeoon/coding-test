package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-06-02 16:00
종료 시간 : 24-06-02 17:32
실행 시간 : 712ms
메 모 리 : 68944KB
*/

public class BOJ_1504_특정한최단경로_G4 {

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }

    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, E, CHK1, CHK2;
    static ArrayList<ArrayList<Node>> adj;
    static final int INF = 200000000;

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            adj.add(new ArrayList<>());
        }

        int from, to, cost;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            adj.get(from).add(new Node(to, cost));
            adj.get(to).add(new Node(from, cost));
        }

        st = new StringTokenizer(br.readLine());
        CHK1 = Integer.parseInt(st.nextToken());
        CHK2 = Integer.parseInt(st.nextToken());
    }

    private static int findRoute(int s, int e){

        boolean[] visited = new boolean[N+1];

        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));


        while (!pq.isEmpty()) {

            Node curNode = pq.poll();
            int cur = curNode.end;

            if(!visited[cur]){
                visited[cur] = true;

                for(Node node : adj.get(cur)){

                    if(!visited[node.end] && dist[node.end] > dist[cur] + node.weight){
                        dist[node.end] = dist[cur] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }

        return dist[e];
    }

    public static void main(String[] args) throws IOException {

        input();

        int res1 = 0;
        res1 += findRoute(1, CHK1);
        res1 += findRoute(CHK1, CHK2);
        res1 += findRoute(CHK2, N);


        int res2 = 0;
        res2 += findRoute(1, CHK2);
        res2 += findRoute(CHK2, CHK1);
        res2 += findRoute(CHK1, N);

        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

        System.out.println(ans);
    }
}