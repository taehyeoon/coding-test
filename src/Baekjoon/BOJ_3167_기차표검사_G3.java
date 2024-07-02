package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_3167_기차표검사_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int cntWhenCheckMin, cntWhenCheckMax, passenger;
    static int[][] train;
    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        train = new int[N][];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int down = Integer.parseInt(st.nextToken());
            int up = Integer.parseInt(st.nextToken());
            passenger += up;
            train[i] = new int[]{down, up};
        }
    }
    public static void main(String[] args) throws IOException {

        input();

        int check = 0, unCheck = 0;
        int checkMin = 0, unCheckMin = 0;
        for (int station = 0; station < N; station++) {

            int down = train[station][0];
            int up = train[station][1];

            // 하차
            if(check >= down){
                check -= down;
            }else{
                unCheck -= down - check;
                check = 0;
            }

            // 티켓 확인 최소로
            if(unCheckMin >= down){
                unCheckMin -= down;
            }else{
                checkMin -= down - unCheckMin;
                unCheckMin = 0;
            }

            // 승차
            unCheck += up;
            unCheckMin += up;

            // 표 검사
            if(station % K == 0){
                check += unCheck;
                checkMin = unCheckMin;
                cntWhenCheckMax += unCheck;
                cntWhenCheckMin += unCheckMin;
                unCheck = 0;
                unCheckMin = 0;
            }
        }

        System.out.print(passenger-cntWhenCheckMax);
        System.out.print(" ");
        System.out.print(passenger - cntWhenCheckMin);
    }
}