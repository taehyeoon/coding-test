package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-08-04 20:00
종료 시간 : 24-08-04 20:30
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_22865_가장먼곳_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, A, B, C;
    static List<int[]>[] edges;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        edges = new List[N+1];
        for (int i = 0; i < N+1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[a].add(new int[]{b, cost});
            edges[b].add(new int[]{a, cost});
        }
    }

    public static void main(String[] args) throws IOException {

        input();

        int[] distA = dijikstra(A);
        int[] distB = dijikstra(B);
        int[] distC = dijikstra(C);

        int home = 0;
        int minDist = 0;
        for (int i = 1; i < N+1; i++) {
            if(i == A || i == B || i == C) continue;

            int dist = Math.min(distA[i], Math.min(distB[i], distC[i]));
            if(dist > minDist) {
                home = i;
                minDist = dist;
            }
        }

        System.out.println(home);
    }

    private static int[] dijikstra(int start){

        int[] dist = new int[N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {

            int cur = q.poll();

            for(int[] edge : edges[cur]) {
                int nextNode = edge[0];
                int cost = edge[1];
                if(dist[cur] + cost < dist[nextNode]){
                    dist[nextNode] = dist[cur] + cost;
                    q.add(nextNode);
                }
            }
        }

        return dist;
    }

}