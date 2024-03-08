package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-08 19:50
종료 시간 : 24-03-08 20:00
실행 시간 : 80ms
메 모 리 : 11520KB
*/

public class BOJ_14916_거스름돈_S5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int[] list = {-99, 2,4,6,8};
        if(N % 5 == 0) {
            System.out.println(N/5);
            return;
        }

        for(int i = 1; i <= 4; i++){
            if(N - list[i] >= 0){
                if((N-list[i])%5 == 0){
                    System.out.println(i+(N-list[i])/5);
                    return;
                }
            }
        }
        System.out.println(-1);
        return;
    }
}