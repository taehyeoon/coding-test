package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간: 24-02-02 09:40
종료 시간: 24-02-02 09:42
실행 시간: 80ms
메모리: 11572KB

고려사항
조합을 이용하여 구현하였습니다
 */

public class BOJ_15655_N과M6_S3 {

	static int N, M;
	static int[] input, result;
	static boolean[] isVisited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		result = new int[M];
		isVisited = new boolean[N];
		
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
			if(cnt != 0 && result[cnt-1] > input[i]) continue;
			if(isVisited[i]) continue;
			result[cnt] = input[i];
			isVisited[i] = true;
			combi(cnt+1, start+1);
			result[cnt] = 0;
			isVisited[i] = false;
		}
	}
}