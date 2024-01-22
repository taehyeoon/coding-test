package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 쉬운최단거리 14940 S1
시작 시간 : 24-01-22 23:45
종료 시간 : 24-01-23 00:45
실행시간 : 2692ms

고려사항
시간초과 해결이 관건
BFS를 통해 구현
도착지점에서 시작하여 4방향 BFS탐색
움직일 때마다 1씩 증가하여 이동 거리를 저장

시간초과 해결 방법
한번 방문한 위치를 visited 배열에 체크하고, 다시 방문하지 않도록 구현
*/

public class Solution14940 {

    static int N, M;
    static int[][] data, result;
    static boolean[][] visited;
    static StringTokenizer st;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N][M];
        result = new int[N][M];
        visited = new boolean[N][M];

        int startI = 0, startJ = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                result[i][j] = -1;
                if(data[i][j] == 2){
                    startI = i;
                    startJ = j;
                }
            }
        }

        result[startI][startJ] = 0;
        visited[startI][startJ] = true;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startI, startJ, 0));

        while (!q.isEmpty()){

            Point p = q.poll();
            int curI = p.i, curJ = p.j;

            result[curI][curJ] = p.val;
            visited[curI][curJ] = true;

            for (int i = 0; i < 4; i++) {
                int nextI = curI + di[i], nextJ = curJ + dj[i];
                if(nextI < 0 || nextJ < 0 || nextI >= N || nextJ >= M) continue;
                if(visited[nextI][nextJ]) continue;
                if(result[nextI][nextJ] != -1 || data[nextI][nextJ] == 0) {
                    visited[nextI][nextJ] = true;
                    continue;
                }
                Point nextP = new Point(nextI, nextJ, p.val + 1);
                if(!q.contains(nextP)){
                    q.add(nextP);
                    visited[nextI][nextJ] = true;
                }


            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(data[i][j] == 0) System.out.print(0 + " ");
                else System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    static class Point{
        int i, j, val;
        public Point(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
        @Override
        public boolean equals(Object obj) {
            if(getClass() == obj.getClass()){
                Point p = (Point) obj;
                return this.i == p.i && this.j == p.j;
            }
            return false;
        }
    }
}