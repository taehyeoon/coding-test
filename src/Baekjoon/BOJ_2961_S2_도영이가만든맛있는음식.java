package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 실행시간 : 72ms
 * 메모리 : 11504KB
 */

public class BOJ_2961_S2_도영이가만든맛있는음식 {
	
	static int N;
	static int[] s;
	static int[] b;
	static boolean[] visited;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		s = new int[N];
		b = new int[N];
		
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		
		System.out.println(ans);
	}
	private static void subset(int depth) {
		
		if(depth == N) {
			int mul = 1;
			int sum = 0;
			for (int i = 0; i < N; ++i) {
				if (visited[i]) {
					mul *= s[i];
					sum += b[i];
				}
			}
			
			if(sum == 0) return;
			
			ans = Math.min(ans, Math.abs(sum - mul));
			return;
		}
		
		visited[depth] = true;
		subset(depth + 1);
		visited[depth] = false;
		subset(depth + 1);
		
	}
	
}

