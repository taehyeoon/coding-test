package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_20955_민서의응급수술 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] parent;

    private static void init(){
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    private static int find(int x){
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;

        if(aRoot < bRoot){
            parent[bRoot] = aRoot;
        }else{
            parent[aRoot] = bRoot;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init();

        int ans = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(!union(a,b)){
                ans++;
            }
        }

        for (int i = 1; i <= N; i++) {
            if(find(i) == i) ans++;
        }

        System.out.println(ans-1);
    }
}