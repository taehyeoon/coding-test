package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_16681_등산_G2 {

    static class Edge implements Comparable<Edge> {
        int vertex;
        long distance;

        public Edge(int vertex, long distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(distance, o.distance);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, D, E;
    static int[] height;
    static Map<Integer, List<Edge>> edges;

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        height = new int[N+1];
        edges = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int vertex = 1; vertex <= N; vertex++) {
            height[vertex] = Integer.parseInt(st.nextToken());
            edges.put(vertex, new ArrayList<>());
        }

        for (int edge = 0; edge < M; edge++) {
            st = new StringTokenizer(br.readLine());
            int ver1 = Integer.parseInt(st.nextToken());
            int ver2 = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            edges.get(ver1).add(new Edge(ver2, dis));
            edges.get(ver2).add(new Edge(ver1, dis));
        }
    }

    static long[] dijkstra(int start){

        PriorityQueue<Edge> q = new PriorityQueue<>();
        long[] distance = new long[N+1];
        Arrays.fill(distance, Long.MAX_VALUE);

        q.offer(new Edge(start, 0));
        distance[start] = 0;

        while (!q.isEmpty()) {
            Edge cur = q.poll();

            // 이미 기록된 거리보다 적게 온 경우 skip
            if(distance[cur.vertex] < cur.distance) continue;

            for (Edge next : edges.get(cur.vertex)) {
                // 다음 산이 같거나 낮으면 못 감
                if(height[cur.vertex] >= height[next.vertex]) continue;

                int nextVertex = next.vertex;
                long nextDis = cur.distance + next.distance;
                if (distance[nextVertex] > nextDis) {
                    distance[nextVertex] = nextDis;
                    q.offer(new Edge(nextVertex, nextDis));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) throws IOException {

        input();

        long[] sWeight = dijkstra(1);
        long[] eWeight = dijkstra(N);

        long maxValue = Long.MIN_VALUE;

        for (int vertex = 1; vertex <= N; vertex++) {
            //
            if(sWeight[vertex] == Long.MAX_VALUE || eWeight[vertex] == Long.MAX_VALUE) continue;
            maxValue = Math.max(maxValue, height[vertex] * E - (sWeight[vertex] + eWeight[vertex]) * D);
        }

        System.out.println(maxValue == Long.MIN_VALUE ? "Impossible" : maxValue);
    }
}