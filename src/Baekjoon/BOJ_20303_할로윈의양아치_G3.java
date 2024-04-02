package com.ssafy.coding;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-01 22:10
종료 시간 : 24-04-02 10:26
실행 시간 : 1708ms
메 모 리 : 48624KB
*/

public class BOJ_20303_할로윈의양아치_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, K, ans;

    static int[] kids;
    static List<Integer>[] adj;
    static List<int[]> data = new ArrayList<>();
    static int[] parent; // for union-find


    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        kids = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            kids[i] = Integer.parseInt(st.nextToken());
        }

        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
    }

    private static void unionInit(){
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }
    private static int find(int v){
        if(parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }

    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;

        if(aRoot < bRoot) parent[bRoot] = aRoot;
        else parent[aRoot] = bRoot;
        return true;
    }
    public static void main(String[] args) throws IOException {

        input();
        unionInit();

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                union(i, adj[i].get(j));
            }
        }
        // data : parent, 사람 , 캔디
        for (int i = 1; i <= N; i++) {

            boolean added = false;
            for (int j = 0; j < data.size(); j++) {
                if(data.get(j)[0] == find(i)){
                    added = true;
                    data.get(j)[1]++;
                    data.get(j)[2] += kids[i];
                    break;
                }
            }
            if(!added){
                int[] temp = new int[]{parent[i], 1, kids[i]};
                data.add(temp);
            }

        }
        
        int[] dp = new int[K];
        for(int[] each : data) {
        	int people = each[1];
        	int candy = each[2];
        	for(int i = K-1; i >= people; i--) {
        		dp[i] = Math.max(dp[i], dp[i-people]+candy); 
        	}
        }
        
        System.out.println(dp[K-1]);
        
    }
}