package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
시작 시간: 24-02-02 10:50
종료 시간: 24-02-02 11:10
실행 시간: 164ms
메모리: 30676KB

고려사항
중복 조합을 통해 해결하였습니다
 */

public class BOJ_15666_N과M12_S2 {

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
			if(cnt!=0 && result[cnt-1] > input[i]) continue;
			result[cnt] = input[i];
			combi(cnt+1);
			
		}
	}
}