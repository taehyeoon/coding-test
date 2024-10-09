package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
시작 시간 : 24-07-10
종료 시간 : 24-07-10
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_5624_좋은수_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[400_002];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(visited[A[i] - A[j] + 200_000]){
                    cnt++;
                    break;
                }
            }
            for (int j = 0; j <= i; j++) {
                visited[A[i] + A[j] + 200_000] = true;

            }
        }


        System.out.println(cnt);


    }
}