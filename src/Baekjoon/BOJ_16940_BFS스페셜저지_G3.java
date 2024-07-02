package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_16940_BFS스페셜저지_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static List<Integer>[] adj;
    static int[] order;
    public static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        adj = new List[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        order = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }


    }
    public static void main(String[] args) throws IOException {

        input();

        if(order[1] != 1) {
            System.out.println(0);
            return;
        }

        boolean[] isVisited = new boolean[N+1];
        isVisited[1] = true;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);

        int ptr = 2;
        while (!q.isEmpty()) {
            int cur = q.poll();

            int count = 0;
            for(int next : adj[cur]){
                if(!isVisited[next]){
                    isVisited[next] = true;
                    count++;
                }
            }

            for (int i = ptr; i < ptr+count; i++) {
                if(!isVisited[order[i]]){
                    System.out.println(0);
                    return;
                }else{
                    q.add(order[i]);
                }
            }
            ptr += count;
        }

        System.out.println(1);
    }
}