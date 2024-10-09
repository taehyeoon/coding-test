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

public class BOJ_2613_숫자구슬_G2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] balls;
    static int[] ansList;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        balls = new int[N];
        ansList = new int[M];
        st = new StringTokenizer(br.readLine(), " ");

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            balls[i] = Integer.parseInt(st.nextToken());
            sum += balls[i];
            min = Math.min(min, balls[i]);
        }

        int lo = min, hi = sum;
        while(lo < hi){
            int mid = (lo + hi) / 2;

            if(canGroup(mid)){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }

        System.out.println(lo);
        for(int i : ansList){
            System.out.print(i + " ");
        }
    }

    private static boolean canGroup(int criteria) {

        int gCnt = 1;
        int mCnt = 0; // 현재 탐색한 구슬 개수
        int sum = 0;

        int[] ballCnts = new int[M];

        for (int i = 0; i < N; i++) {
            if(gCnt > M || balls[i] > criteria){
                return false;
            }

            if(sum + balls[i] > criteria || N - 1 <= M - gCnt){
                ballCnts[gCnt-1] = mCnt;
                gCnt++;
                mCnt = 1;
                sum = balls[i];
            }else{
                mCnt++;
                sum += balls[i];
            }
        }

        if(gCnt > M){
            return false;
        }

        ballCnts[gCnt-1] = mCnt;

        for (int i = 0; i < M; i++) {
            ansList[i] = ballCnts[i];
        }

        return true;


    }
}