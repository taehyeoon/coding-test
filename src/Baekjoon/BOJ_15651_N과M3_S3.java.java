package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-02 01:56
종료 시간 : 24-02-02 02:00
실행 시간 : 372ms
메 모 리 : 112104KB

고려사항
*/

public class BOJ_15651_N과M3_S3 {

	static int N, M;
	static int[] input, result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		result = new int[M];
		for(int i = 0; i < N; i++){
			input[i] = i+1;
		}
		permutation(0);
		System.out.print(sb);
	}

	private static void permutation(int idx) {

		if(idx == M){
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;

		}

		top:
		for(int i = 0; i < N; i++){
			result[idx] = input[i];
			permutation(idx+1);
		}
	}

}