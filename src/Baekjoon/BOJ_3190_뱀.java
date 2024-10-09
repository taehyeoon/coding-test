package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_3190_뱀 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우하좌상
    static int N, K, L, headDir;
    static boolean[][] appleMap, snakeMap;
    static Deque<int[]> snake = new ArrayDeque<>();
    static Queue<int[]> cmds = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        appleMap = new boolean[N][N];
        snakeMap = new boolean[N][N];

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            appleMap[a-1][b-1] = true;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);

            cmds.add(new int[]{t, d});
        }

        snake.addFirst(new int[]{0, 0});
        snakeMap[0][0] = true;

        int time = 0;
        while(true){


            time++;

            // 현재 방향으로 이동
            int chi = snake.peek()[0]; // current head i idx
            int chj = snake.peek()[1];

            int nhi = chi + dir[headDir][0];
            int nhj = chj + dir[headDir][1];

            // 벽 외부
            if(nhi < 0 || nhi >= N || nhj < 0 || nhj >= N){
                break;
            }


            if(snakeMap[nhi][nhj]){
                break;
            }

            // 꼬리 이동
            // 사과인 경우
            if(appleMap[nhi][nhj]){
                appleMap[nhi][nhj] = false;
            }else{
                // 사과가 아닌 경우
                int[] tail = snake.pollLast();
                snakeMap[tail[0]][tail[1]] = false;
            }

            // 머리 이동
            snake.addFirst(new int[]{nhi, nhj});
            snakeMap[nhi][nhj] = true;

            // 방향 바꾸기
            if(!cmds.isEmpty() && cmds.peek()[0] == time){
                int d = cmds.poll()[1];

                headDir =  d == 'L' ? (headDir + 3) % 4 : (headDir + 1) % 4;
            }
        }

        System.out.println(time);

    }

}