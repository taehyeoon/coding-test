package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
시작 시간 : 24-02-01 00:10
종료 시간 : 24-02-01 00:55
실행시간 : 76ms

고려사항
재귀로 풀이
마지막 타일을 1개로 끝내는 경우와 2개롤 끝나는 경우의 수를 합하여
현재까지의 가능한 타일 개수를 계산
주의 : 마지막이 2개로 끝나는 경우가, 마지막이 1개롤끝나는 경우를 포함하고 있어
재귀를 진행할 때, 3이 아니라 2를 곱해야 함
주의 : 재귀 함수가 아닌 for문으로 구성해야
채점 시 ArrayOutOfBoundsException을 막을 수 있음
*/

public class BOJ_11727_2xn타일링2_S3 {

	static long[] memo;
	static int N;
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		memo = new long[1001];

		memo[1] = 1;
		memo[2] = 3;

		for(int i = 3; i <= N; i++){
			memo[i] = (memo[i-1] + 2 * memo[i-2]) % 10007;
		}
		System.out.println(memo[N]);
	}
}