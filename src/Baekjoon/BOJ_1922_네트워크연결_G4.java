package Baekjoon;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-25
종료 시간 : 24-02-25
실행 시간 : 356ms
메 모 리 : 44428KB
*/

public class BOJ_1922_네트워크연결_G4 {

    static class Vertex implements Comparable<Vertex> {
        int no;
        int weight;

        public Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.weight - o.weight;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;


    static int N, M;
    static int[][] map;
    static boolean[] isVisited;
    static int[] minEdge;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        isVisited = new boolean[N+1];
        minEdge = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[a][b] = w; map[b][a] = w;
        }

        for (int i = 1; i <= N; i++) {
            minEdge[i] = Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) throws IOException {

        input();

        PriorityQueue<Vertex> q = new PriorityQueue<>();

        int result = 0;
        minEdge[1] = 0; // 시작점

        q.offer(new Vertex(1, minEdge[1]));

        int cnt = 0;
        while (!q.isEmpty()) {

            Vertex minVertex = q.poll();
            if(isVisited[minVertex.no]) continue;

            result += minVertex.weight;
            isVisited[minVertex.no] = true;
            if(++cnt == N) break;

            for (int i = 1; i <= N; i++) {
                if (!isVisited[i] && map[minVertex.no][i] != 0 && map[minVertex.no][i] < minEdge[i]){
                    minEdge[i] = map[minVertex.no][i];
                    q.offer(new Vertex(i, minEdge[i]));
                }
            }
        }

        System.out.println(result);

        br.close();
    }
}
