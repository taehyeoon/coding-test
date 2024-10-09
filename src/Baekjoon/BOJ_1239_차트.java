package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1239_차트 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, ans;
    static int[] arr;
    static int[] data;

    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        data = new int[N];
        isSelected = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        per(0);

        System.out.println(ans);
    }

    private static void per(int x) {

        if(x == N){
            //check
            ans = Math.max(ans, check(data));
        }

        for (int i = 0; i < N; i++) {
            if(!isSelected[i]){
                isSelected[i] = true;
                data[x] = arr[i];
                per(x + 1);
                isSelected[i] = false;
            }
        }

    }

    private static int check(int[] d){

        int cnt = 0;
        for (int s = 0; s < N; s++) {

            int sum = 0;
            for (int i = 0; i < N; i++) {
                if(sum == 50){
                    cnt++;
                    break;
                }else{
                    sum += d[(s + i) % N];
                }
            }
        }

        return cnt / 2;
    }
}