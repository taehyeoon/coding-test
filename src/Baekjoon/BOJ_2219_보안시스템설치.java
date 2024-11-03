package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_2219_보안시스템설치 {

    static int N, M;
    static int[][] adj;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i!=j)
                    adj[i][j] = 1000000;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken());
            adj[y][x] = adj[x][y] = v;
        }
        for (int k = 0; k < N; k++) { // 플로이드 와샬 적용
            for (int i = 0; i < N; i++) {
                if(i == k)
                    continue;
                for (int j = 0; j < N; j++) {
                    if(i == j || j == k)
                        continue;
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
        int ans[] = new int[N]; // 컴퓨터별 성능 저장
        int min = Integer.MAX_VALUE; // 최소값 저장
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += adj[i][j];
            }
            ans[i] = sum;
            min = Math.min(min, sum);
        }
        for (int i = 0; i < N; i++) {
            if(min == ans[i]) {
                System.out.println(i+1);
                break;
            }
        }
    }
}