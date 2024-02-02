package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/*
시작 시간: 24-02-02 09:10
종료 시간: 24-02-02 09:30
실행 시간: 124ms
메모리: 20332KB

고려사항
순열을 이용하여 해결하였습니다.
두번째 이후의 숫자를 고르는 경우에 왼쪽 숫자보다 작은 경우는
제외하며, 순열을 구하였습니다.
 */

public class BOJ_15652_N과M4_S3 {

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
		
		for(int i = 0; i < N; i++) input[i] = i+1;
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
			if(cnt != 0 && result[cnt-1] > input[i]) continue;
			result[cnt] = input[i];
			combi(cnt+1, start+1);
			result[cnt] = 0;
		}
	}
}