package com.ssafy.coding;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-08 17:15
종료 시간 : 24-04-08 17:25
실행시간 : 115ms / 실패
메 모 리 : 30040KB
*/


public class SWEA_5604_구간합_D4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static long a, b, ans, mul;
	static long[] numbers;
	
	private static void calc(long x) {
		for (long i = x; i > 0; i /= 10) {
			String s = Long.toString(i);
			int t = s.charAt(s.length()-1)-'0';
			numbers[t]+=mul;				
		}
	}
	
	public static void main(String[] args) throws IOException {
	
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			numbers = new long[10];
			ans = 0;
			mul = 1;
			
			if(a == 0) a = 1;
			while(a <= b) {
				
				while(a % 10!=0 && a<=b) {
					calc(a);
					a++;
				}
				if(a>b) break;
				while(b % 10!=9 && a<=b) {
					calc(b);
					b--;
				}
				long diff = b/10 - a/10 +1;
				for(int i=0;i<10;i++)
					numbers[i] += diff*mul;
				mul*=10;
				a /=10;
				b/=10;
			}
			
			for (int i = 1; i < 10; i++)
				ans += (i * numbers[i]);

			sb.append(String.format("#%d %d%n", tc, ans));
		}
		System.out.println(sb);
	}
}
