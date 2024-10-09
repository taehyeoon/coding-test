package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_21738_얼음깨기펭귄_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, S, P;
    static List<Integer>[] adj;
    static int[] dist;

    static boolean[] isPillar;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        adj = new List[N+1];
        for(int i=1;i<=N;i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        isPillar = new boolean[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];
        visited[P] = true;
        dist[P] = 0;

        Arrays.fill(isPillar, 1, S+1, true);

        for(int near : adj[P]){
            dfs(near, 0);
        }

        int[] pill = Arrays.copyOfRange(dist, 1, S + 1);
        Arrays.sort(pill);

        System.out.println(N - (pill[0] + pill[1]+1));
    }

    private static void dfs(int cur, int cost) {

        if(visited[cur]) return;

        visited[cur] = true;
        if(isPillar[cur]) {
            dist[cur] = cost + 1;
        }

        for(int near : adj[cur]){
            dfs(near, cost + 1);
        }
    }
}