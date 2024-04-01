package com.ssafy.coding;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-04-01
종료 시간 : 24-04-01
실행시간 : ms
메 모 리 : KB
*/

public class BOJ_15732_도토리숨기기_G2 {

	static class Data implements Comparable<Data>{
		int a, b, c;
		
		

		public Data(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}



		@Override
		public int compareTo(Data o) {

			if(this.a == o.a) return this.b - o.b;
			return this.a - o.a;
		}
		
		
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, K, D, lo, hi;
	static Data[] rules;
	
	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		lo = Integer.MAX_VALUE;
		hi = 0;
		rules = new Data[K];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			int c = Integer.parseInt(st.nextToken()); 
			rules[i] = new Data(a,b,c);
			lo = Math.min(lo, a);
			hi = Math.max(hi, b);
		}
	}
	
	private static long countDotori(int x) {
		
		long sum = 0;
		for(int i = 0; i < K; i++) {
			int a = rules[i].a, b = rules[i].b, c = rules[i].c; 

			if(a>x) continue;
			
			if(b < x) {
				sum += (b-a)/c + 1;
			}else {
				sum += (x-a)/c + 1;
			}
		}
		return sum;
		
	}
	public static void main(String[] args) throws IOException {
		
		input();
		
		Arrays.sort(rules);
		
		hi++;
		lo--;
		while(lo+1 < hi) {
			int mid = (lo+hi) / 2;
			if(countDotori(mid) >= D) {
				hi = mid;
			}
			else {
				lo = mid;
			}
		}
		System.out.println(hi);
	}
}
