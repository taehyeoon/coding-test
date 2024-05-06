package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-07 00:00
종료 시간 : 24-05-07 02:40
실행 시간 : 2916ms / 실패
메 모 리 : 71620KB
*/

public class BOJ_12763_지각하면안돼_G2 {

    static class Info{
        int dest, time, cost;

        public Info(int dest, int time, int cost) {
            this.dest = dest;
            this.time = time;
            this.cost = cost;
        }
    }

    static class Info2{
        int time, cost, here;

        public Info2(int time, int cost, int here) {
            this.time = time;
            this.cost = cost;
            this.here = here;
        }
    }

    static int N, T, M;

    static List<Info>[] edges = new List[10_001];
    static int[][] cost = new int[101][10_001];
    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N+1; i++) {
            for (int j = 0; j < 10_001; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < N+1; i++) {
            edges[i] = new ArrayList<>();
        }
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            edges[from].add(new Info(to, time, money));
            edges[to].add(new Info(from, time, money));
        }
    }
    public static void main(String[] args) throws IOException {

        input();

        PriorityQueue<Info2> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
        cost[1][0] = 0;
        pq.add(new Info2(0,0,1));

        while (!pq.isEmpty()) {
            int curTime = pq.peek().time;
            int curCost = pq.peek().cost;
            int curX = pq.peek().here;
            pq.poll();
            if(cost[curX][curCost] < curTime) continue;

            for (int i = 0; i < edges[curX].size(); i++) {
                int nextCost = curCost + edges[curX].get(i).cost;
                if(nextCost > M) continue;

                int nextTime = edges[curX].get(i).time;
                int nextX = edges[curX].get(i).dest;
                if (cost[nextX][nextCost] > curTime + nextTime) {
                    cost[nextX][nextCost] = curTime + nextTime;
                    pq.add(new Info2(cost[nextX][nextCost], nextCost, nextX));
                }
            }
        }

        int ans = -1;
        for (int i = 0; i <= M; i++) {
            if(cost[N][i] <= T){
                ans = i;
                break;
            }
        }
        System.out.println(ans);

    }
}