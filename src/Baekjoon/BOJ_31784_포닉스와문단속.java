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

public class BOJ_31784_포닉스와문단속 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        char[] input = br.readLine().toCharArray();

        int idx = 0;
        while(K > 0){

            if(idx == N-1){
                // 나머지 처리
                input[N-1] = (char)(((input[N-1] + K - 'A') % 26) + 'A');
                break;
            }else{
                if(input[idx] != 'A') {
                    if(input[idx] + K > 'Z'){
                        K -= 'Z' - input[idx] + 1;
                        input[idx] = 'A';
                    }
                }
                idx++;
            }
        }

        System.out.println(String.valueOf(input));
    }
}