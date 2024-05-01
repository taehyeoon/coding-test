package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-01 19:50
종료 시간 : 24-05-01 20:00
실행 시간 : 2704ms
메 모 리 : 292532KB
*/

public class BOJ_7983_내일할거야_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] tasks;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        tasks = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            tasks[i][0] = Integer.parseInt(st.nextToken());
            tasks[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tasks, ((o1, o2) -> o2[1] - o1[1]));

        int day = tasks[0][1];

        for (int i = 0; i < N; i++) {
            if(day < tasks[i][1]){
                day -= tasks[i][0];
            }else if(day >= tasks[i][1]){
                day = tasks[i][1] - tasks[i][0];
            }
        }

        System.out.println(day);
    }
}