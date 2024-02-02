package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간: 24-02-02 10:10
종료 시간: 24-02-02 10:17
실행 시간: 144ms
메모리: 23176KB

고려사항
중복 조합을 이용하여 구현하였습니다
 */

public class BOJ_15657_N과M8_S3 {

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
		for(int i = 0; i < N; i++) input[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(input);
		
		combi(0);
		
		System.out.print(sb);
	}	

	private static void combi(int cnt) {

		if(cnt == M) {
			for(int i = 0; i < M; i++) sb.append(result[i] +" ");
			sb.append('\n');
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(cnt != 0 && result[cnt-1] > input[i]) continue;
			result[cnt] = input[i];
			combi(cnt+1);
		}
	}
}