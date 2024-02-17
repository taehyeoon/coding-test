package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-02-17 17:15
종료 시간 : 24-02-17 17:40
실행시간 : 640ms
메 모 리 : 53420KB
*/

public class BOJ_1197_최소스패닝트리_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int V, E, ans;
    static int[] parent;
    static int[][] graph;


    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V+1];
        graph = new int[E][3];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }
    }
    private static void solve(){

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
        Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < E; i++) {
            if(find(graph[i][0]) == find(graph[i][1])) continue;

            ans += graph[i][2];
            union(graph[i][0], graph[i][1]);
        }
    }
    private static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }

    private static int find(int a){
        if(parent[a] == a) return a;
        return find(parent[a]);
    }

    public static void main(String[] args) throws IOException {

        input();
        solve();
        System.out.println(ans);
    }
}
