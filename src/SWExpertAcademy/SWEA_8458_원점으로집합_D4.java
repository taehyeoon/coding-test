package com.ssafy.coding;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-01
종료 시간 : 24-04-01
실행시간 : 292ms
메 모 리 : 48180KB
*/

public class SWEA_8458_원점으로집합_D4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[] data;
	
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int tc = 1; tc <= TC; tc++) {
			
			N = Integer.parseInt(br.readLine());
			data = new int[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				data[i] = Math.abs(x) + Math.abs(y); 
			}
			
			Arrays.sort(data);
			int max = data[N-1];
			if(max == 0) {
				sb.append(String.format("#%d %d%n", tc, 0));
				continue;
			}
			long sum = 0;
			int maxIdx = 1;
			for(; maxIdx <= Integer.MAX_VALUE; maxIdx++) {
				sum+=maxIdx;
				
				
				if(sum >= max && (sum - max) % 2 == 0) break;
			}
			
			boolean success = true;
			for(int i = 0; i < N-1; i++) {
				if((sum - data[i]) % 2 != 0) {
					success = false;
					break;
				}
			}
			
			int res;
			if(success) res = maxIdx;
			else res = -1; 
			
			sb.append(String.format("#%d %d%n", tc, res));
		}
		System.out.println(sb);
	}
}
