package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
시작 시간: 24-02-02 
종료 시간: 24-02-02 
실행 시간: ms
메모리: KB

고려사항
 */

public class BOJ_15665_N과M11_S2 {

	static int N, M;
	static int[] input, result;
	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new HashSet<>();
	
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
			StringBuilder tempSb = new StringBuilder();
			for(int i = 0; i < M; i++) tempSb.append(result[i] +" ");
				
			if(!set.contains(tempSb.toString())) {
				set.add(tempSb.toString());
				sb.append(tempSb);
				sb.append('\n');
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			result[cnt] = input[i];
			combi(cnt+1);
			
		}
	}
}