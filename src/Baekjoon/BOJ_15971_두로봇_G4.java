package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-06-02 03:01
종료 시간 : 24-06-02 04:37
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_15971_두로봇_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, S, E;
    static List<int[]>[] adj;
    static int[] prevPtr;

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        prevPtr = new int[N+1];
        adj = new List[N+1];
        for (int i = 0; i < N + 1; i++) {
            adj[i] = new ArrayList<int[]>(); // 다음 노드, 거리
        }

        int s, e, d;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            adj[s].add(new int[]{e, d});
            adj[e].add(new int[]{s, d});
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        if(N == 1 || S == E) {
            System.out.println(0);
            return;
        }


        boolean[] visited = new boolean[N+1];
        visited[S] = true;

        // prev, cur, cost
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.add(new int[]{-1, S, 0});
        while (!pq.isEmpty()) {
            int cNode = pq.peek()[1];
            prevPtr[cNode] = pq.peek()[0];
            pq.poll();

            if(cNode == E){
                break;
            }

            for (int i = 0; i < adj[cNode].size(); i++) {
                if(visited[adj[cNode].get(i)[0]]) continue;
                visited[adj[cNode].get(i)[0]] = true;
                pq.add(new int[]{cNode, adj[cNode].get(i)[0], adj[cNode].get(i)[1]});
            }
        }

        List<Integer> route = new ArrayList<>();
        int end = E;
        int prev = prevPtr[end];
        while(prev != S){
            for (int i = 0; i < adj[end].size(); i++) {
                if(adj[end].get(i)[0] == prev){
                    route.add(adj[end].get(i)[1]);

                    end = prev;
                    prev = prevPtr[end];
                    break;
                }
            }
        }

        for (int i = 0; i < adj[end].size(); i++) {
            if(adj[end].get(i)[0] == prev){
                route.add(adj[end].get(i)[1]);

                end = prev;
                prev = prevPtr[end];
                break;
            }
        }

        Collections.sort(route);
        int sum = 0;
        for (int i = 0; i < route.size()-1; i++) {
            sum += route.get(i);
        }

        System.out.println(sum);
    }
}