package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간: 24-02-02 09:45
종료 시간: 24-02-02 09:49
실행 시간: 880ms
메모리: 407784KB

고려사항
조합을 이용하여 구현하였습니다
 */

public class BOJ_15656_N과M7_S3 {

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
		combi(0, 0);
		
		System.out.print(sb);
	}	

	private static void combi(int cnt, int start) {

		if(cnt == M) {
			for(int i = 0; i < M; i++) sb.append(result[i] +" ");
			sb.append('\n');
			return;
		}
		
		for(int i = 0; i < N; i++) {
			result[cnt] = input[i];
			combi(cnt+1, start+1);
		}
	}
}