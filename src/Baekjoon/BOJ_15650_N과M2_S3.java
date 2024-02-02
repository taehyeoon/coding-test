package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-02 01:50
종료 시간 : 24-02-02 01:55
실행 시간 : 80ms
메 모 리 : 11528KB

고려사항
순열을 이용하여 해결
순열을 계산할 때, start index를 이용하여 start보다 같거나 큰 범위에서
재귀적인 수열 생성
-> 항상 오름차순인 수열을 만들기 위함
*/

public class BOJ_15650_N과M2_S3 {

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

		permutation(0, 0);
		System.out.print(sb);
	}

	private static void permutation(int idx, int start) {

		if(idx == M){
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;

		}

		top:
		for(int i = start; i < N; i++){
			for(int j = 0; j < idx; j++){
				if(input[i] == result[j]) continue top;
			}
			result[idx] = input[i];
			permutation(idx+1, i+1);
		}
	}

}