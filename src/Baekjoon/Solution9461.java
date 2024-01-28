package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 파도반수열 9461 S3
시작 시간 : 24-01-28 17:40
종료 시간 : 24-01-28 18:00
실행시간 : 80ms

고려사항
dp의 top-down방식에 메모이제이션을 이용하여 해결하였습니다.
int형 대신 long형을 사용하는 것이 중요한 문제였습니다
최악의 경우인 N = 100인 경우, int 자료형의 overflow가 발생하기 때문에
long형을 이용해서 값을 저장해야 합니다.
 */

public class Solution9461 {

    static int N;
    static long[] memo;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        memo = new long[101];
        memo[1] = 1;
        memo[2] = 1;
        memo[3] = 1;
        memo[4] = 2;
        memo[5] = 2;

        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(br.readLine());
            sb.append(dp(X)).append('\n');
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }

    private static long dp(int x) {

        if(memo[x] == 0){
            memo[x] = dp(x-1) + dp(x-5);
        }

        return memo[x];
    }
}