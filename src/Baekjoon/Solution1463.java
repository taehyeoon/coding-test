package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 1로만들기 1463 S3
시작 시간 : 24-01-20 00:41
종료 시간 : 24-01-28 11:00
실행시간 : 108ms / 실패

고려사항
정답 참조
dp를 이용해서 N보다 작은 수들의 해를 미리 저장하는 방식으로 해결하는 문제였습니다.
bottom-up방식을 이용
k수가 가지는 해는 = min((k-1)값 + 1, (k/2)+1, (k/3)+1) 입니다.
k/2와 k/3는 2와 3으로 나누어 떨어지는 경우에만 고려하면 됩니다.
작은 수부터 N까지 계산하며 최종 N값의 결과를 알아낼수 있습니다.
 */

public class Solution1463 {
    static int N;
    static int[] memo;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        memo = new int[N+1];
        memo[0] = 0;
        memo[1] = 0;
        for (int i = 2; i <= N; i++) {
            memo[i] = memo[i-1] + 1;
            if(i % 2 == 0) memo[i] = Math.min(memo[i], memo[i/2] + 1);
            if(i % 3 == 0) memo[i] = Math.min(memo[i], memo[i/3] + 1);
        }
        System.out.println(memo[N]);
    }
}