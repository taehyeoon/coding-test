package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-02-17 15:50
종료 시간 : 24-02-17 16:20
실행시간 : 76ms
메 모 리 : 11760KB
*/

public class BOJ_2644_촌수계산_S2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, S, E, ans;
    static List<Integer>[] links;
    static boolean[] isVisited;
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        links = new LinkedList[N+1];
        for (int i = 0; i < N+1; i++) {
            links[i] = new LinkedList<>();
        }
        isVisited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            links[a].add(b);
            links[b].add(a);
        }
    }
    private static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        isVisited[S] = true;

        while(!q.isEmpty()){
            ans++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int next = q.poll();
                if(next == E) return;

                for (int j = 0; j < links[next].size(); j++) {
                    int adj = links[next].get(j);
                    if(adj == E) return;

                    if(isVisited[adj]) continue;
                    isVisited[adj] = true;

                    q.add(adj);
                }
            }
        }
        ans = -1;
    }
    public static void main(String[] args) throws IOException {

        input();
        bfs();
        System.out.println(ans);
    }
}
