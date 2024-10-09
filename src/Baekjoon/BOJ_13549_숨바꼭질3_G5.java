package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-14 20:35
종료 시간 : 24-04-14
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_13549_숨바꼭질3_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int time = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);

        Set<Integer> visited = new HashSet<>();
        visited.add(N);

        Find:
        while (!q.isEmpty()) {

            int qSize = q.size();

            for (int iter = 0; iter < qSize; iter++) {
                int cur = q.poll();

                // 2배가 도착
                int next = cur;
                while(next != K){

                    next *= 2;
                    if(next > MAX) break ;

                    if(next-1 == K) {
                        time++;
                        break Find;
                    }else if (next-1 < MAX && !visited.contains(next-1)){

                    }
                }

                // cur-1이 도착

                // cur+1이 도착

            }

            time++;
        }
        System.out.println(time);
    }
}