package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-04-11 23:30
종료 시간 : 24-04-11
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1405_미친로봇_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static double[] percent = new double[4];
    static int[] count = new int[4];
    static double ans;

    private static void dfs(int dir, double stocastic, int cnt){

        if(count[0] == count[2] && count[1] == count[3]){
            ans += stocastic;
            return;
        }

        if(cnt == N) {
           return;
        }

        for (int i = 0; i < 4; i++) {
            if(i == dir)
            if(percent[i] != 0){




            }
        }

    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            percent[i] = Double.parseDouble(st.nextToken()) / 100;
        }

        for (int i = 0; i < 4; i++) {
            dfs(i, percent[i], 1);
        }
    }
}