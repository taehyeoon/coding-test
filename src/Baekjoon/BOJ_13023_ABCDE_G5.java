package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-06 13:00
종료 시간 : 24-04:06 13:12
실행 시간 : 232ms
메 모 리 : 14608KB
*/

public class BOJ_13023_ABCDE_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static List<Integer>[] adj;
    static boolean[] friends;
    private static void input() throws IOException{

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new List[N];
        friends = new boolean[N];

        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

    }

    private static boolean dfs(int x, int cnt){

        if(cnt == 5){
            return true;
        }

        for (int i = 0; i < adj[x].size(); i++) {
            if(friends[adj[x].get(i)]) continue;

            friends[adj[x].get(i)] = true;
            if(dfs(adj[x].get(i), cnt+1)) return true;
            friends[adj[x].get(i)] = false;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {

        input();

        for (int i = 0; i < N; i++) {
            friends[i] = true;
            if(dfs(i, 1)){
                System.out.println(1);
                return;
            }
            friends[i] = false;
        }

        System.out.println(0);

    }
}