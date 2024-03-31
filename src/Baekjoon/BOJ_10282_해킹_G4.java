package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-30 23:25
종료 시간 : 24-03-30 23:50
실행 시간 : 836ms
메 모 리 : 159972KB
*/

public class BOJ_10282_해킹_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, D, C;
    static List<int[]>[] adj;

    private static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < D; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            adj[b].add(new int[]{a, s});
        }
    }
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            input();

            int virusCnt = 0;
            int ansTime = 0;
            boolean[] visit = new boolean[N+1];

            // (도착지, 감염 경과시간)
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
            pq.offer(new int[]{C, 0});

            while (!pq.isEmpty()){

                int[] cur = pq.poll();
                int curCom = cur[0];
                int curTime = cur[1];

                if(visit[curCom]) continue;
                visit[curCom] = true;

                virusCnt++;
                ansTime = Math.max(ansTime, curTime);

                for(int i = 0; i < adj[curCom].size(); i++){
                    int next = adj[curCom].get(i)[0];
                    int waitingTime = adj[curCom].get(i)[1];

                    pq.offer(new int[]{next, curTime + waitingTime});
                }

            }

            sb.append(virusCnt).append(" ").append(ansTime).append("\n");
        }
        System.out.println(sb);
    }
}