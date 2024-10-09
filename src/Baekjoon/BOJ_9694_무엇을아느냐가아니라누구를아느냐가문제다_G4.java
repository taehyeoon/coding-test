package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_9694_무엇을아느냐가아니라누구를아느냐가문제다_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int TC, N, M;
    static List<int[]>[] edges;
    static List<Integer>[] order;

    public static void main(String[] args) throws IOException {

        TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            edges = new List[M];
            order = new ArrayList[M];
            for (int i = 0; i < M; i++) {
                edges[i] = new ArrayList<int[]>();
                order[i] = new ArrayList();
            }
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                edges[a].add(new int[] {b, cost});
                edges[b].add(new int[] {a, cost});
            }

            int[] dist = new int[M];
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            order[0].add(0);

            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = 0;

            while (!q.isEmpty()) {

                int cur = q.poll();

                for(int[] edge : edges[cur]) {
                    int next = edge[0];
                    int cost = edge[1];

                    if(dist[cur] + cost < dist[next]) {
                        dist[next] = dist[cur] + cost;
                        List<Integer> list = new ArrayList<>(order[cur]);
                        list.add(next);
                        order[next] = list;
                        q.add(next);
                    }
                }
            }

            System.out.print("Case #"+tc + ": ");
            if(dist[M - 1] != Integer.MAX_VALUE){
                for(int o : order[M-1])
                    System.out.print(o+" ");
            }else{
                System.out.println(-1);
            }
            System.out.println();
        }

    }
}