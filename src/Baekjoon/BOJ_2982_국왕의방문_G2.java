package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-30 18:30
종료 시간 : 24-03-30
실행 시간 : 244ms
메 모 리 : 44032KB
*/

public class BOJ_2982_국왕의방문_G2 {

    static class Road {
        int from, to;
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, S, E, K, G;
    static int[] kingMove;
    static List<int[]>[] adj; // (to, weight)
    static int[][] weight;
    static Road[][] kingRoute;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        kingMove = new int[G];
        for (int i = 0; i < G; i++) {
            kingMove[i] = Integer.parseInt(st.nextToken());
        }

        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        weight = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            adj[u].add(new int[]{v, l});
            adj[v].add(new int[]{u, l});
            weight[u][v] = weight[v][u] = l;
        }


    }
    public static void main(String[] args) throws IOException {
        input();

        // 왕 이동에 따른 도로 사용여부 체크
        int time = 0;
        kingRoute = new Road[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                kingRoute[i][j] = new Road();
            }
        }
        for (int i = 1; i < G; i++) {
            int p = kingMove[i-1];
            int q = kingMove[i];

            kingRoute[p][q].from = kingRoute[q][p].from = time;
            time += weight[p][q];
            kingRoute[p][q].to = kingRoute[q][p].to = time;
        }


        // 다익스트라
        int[] minDist = new int[N+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        // (to, weight)
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        minDist[S] = K;
        pq.offer(new int[]{S, K});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();
            int to = cur[0], weight = cur[1];

            if(minDist[to] < weight) continue;

            for (int i = 0; i < adj[to].size(); i++) {
                int next = adj[to].get(i)[0];
                int next_weight = adj[to].get(i)[1];


                // 만약 다음노드를 가는데 현재 노드를 거쳐가는 것이 더 짧은 경우
                if(minDist[next] > minDist[to] + next_weight){
                    // 만약 왕때문에 기다려야 하는 경우
                    if(kingRoute[to][next].from <= minDist[to] && minDist[to] < kingRoute[to][next].to){
                        minDist[next] = kingRoute[to][next].to + next_weight;
                    }else{
                        minDist[next] = minDist[to] + next_weight;
                    }
                    pq.offer(new int[]{next, minDist[next]});

                }
            }

        }

        System.out.println(minDist[E] - K);

    }
}