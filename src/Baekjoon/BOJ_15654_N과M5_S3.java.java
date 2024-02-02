package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-02 01:10
종료 시간 : 24-02-02 01:37
실행 시간 : 280ms
메 모 리 : 31744KB

고려사항
순열을 활용하여 풀이하였습니다.
주의 매번 순열을 구할때마다 System.out.print를 이용하여
출력하면 시간초과가 발생합니다
따라서 StringBuilder를 통해 문자열을 모두 저장후
마지막에 한번에 출력해야합니다.
*/

public class BOJ_15654_N과M5_S3 {

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
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
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
			for(int j = 0; j < idx; j++){
				if(input[i] == result[j]) continue top;
			}
			result[idx] = input[i];
			permutation(idx+1);
		}
	}

}