package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-09 12:25
종료 시간 : 24-02-09 13:40
실행시간 : 544ms / 실패
메 모 리 : 11725KB

고려사항

*/

public class BOJ_11725_트리의부모찾기_S2 {

    static int N;
    static ArrayList<Integer>[] adj;
    static boolean[] isVisited;
    static int[] parents;
    static StringBuilder sb = new StringBuilder();

    private static void input() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int a, b;
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        isVisited = new boolean[N+1];
        parents = new int[N+1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        Queue<Integer> q = new LinkedList<>();
        isVisited[1] = true;
        q.add(1);
        while(!q.isEmpty()){
            int cur = q.poll();

            for(int data : adj[cur]){
                if(isVisited[data]) continue;

                isVisited[data] = true;
                parents[data] = cur;
                q.add(data);
            }
        }

        for(int i = 2; i <= N; i++)
            sb.append(parents[i]).append("\n");
        System.out.println(sb);
    }
}