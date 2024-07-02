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

public class BOJ_21278_호석이두마리치킨_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static List<Integer>[] edges;
    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new List[N+1];
        for (int i = 0; i < N + 1; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }
    }
    public static void main(String[] args) throws IOException {

        input();

        int[][] dis = new int[N+1][N+1];

        for (int s = 1; s <= N; s++) {
            Queue<Integer> q = new ArrayDeque<>();
            q.add(s);
            boolean[] visited = new boolean[N+1];
            visited[s] = true;
            int len = 0;
            while (!q.isEmpty()){
                int size = q.size();
                len++;
                for (int iter = 0; iter < size; iter++) {
                    int cur = q.poll();

                    for (int i = 0; i < edges[cur].size(); i++) {
                        int next = edges[cur].get(i);
                        if(visited[next]) continue;

                        visited[next] = true;
                        dis[s][next] = len;
                        q.offer(next);
                    }
                }
            }
        }

        int a = 0, b = 0, ans = Integer.MAX_VALUE;

        for (int fir = N; fir >= 1; fir--) {
            for (int sec = N; sec >= 1; sec--) {
                int sum = 0;

                for (int i = 1; i <= N; i++) {
                    sum += 2*(Math.min(dis[i][fir], dis[i][sec]));

                }
                if(sum <= ans){
                    ans = sum;
                    a = fir; b = sec;
                }
            }
        }

        System.out.println(a + " " + b + " " + ans);
    }
}