package com.ssafy.coding;

import java.io.*;

/*
시작 시간 : 24-03-29
종료 시간 : 24-03-29
실행시간 : 484ms / KMP 알고리즘 / 수업
메 모 리 : 52116KB
*/

public class BOJ_1786_찾기_P5 {
	
	private static int[] getPI(String pattern) {
		
		int n = pattern.length();
		int[] pi = new int[n];

		int j = 0;
		for(int i = 1; i < pattern.length(); i++) {
			
			while(j>0 && pattern.charAt(i) != pattern.charAt(j))
				j = pi[j-1];
			
			if(pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String origin = br.readLine();
		String pattern = br.readLine();
		
		int[] pi = getPI(pattern);
		
		
		int pn = pattern.length();
		int j = 0;
		int findCnt = 0;
		for(int i = 0; i < origin.length(); i++) {
			
			while(j>0 && origin.charAt(i) != pattern.charAt(j))
				j = pi[j-1];
			
			if(origin.charAt(i) == pattern.charAt(j)) {
				
				if(j == pn-1) {
					findCnt++;
					sb.append(i-pn+2).append("\n");
					j = pi[j];
				}else {
					j++;
				}
			}
		}
		
		System.out.println(findCnt);
		System.out.println(sb);
	}
}
