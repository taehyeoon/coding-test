package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 실행 시간 : 80ms
 * 메모리 : 11588KB
 */
public class BOJ_2023_G5_신기한소수 {
	
	static int N;
	static char[] first = {'2','3','5','7'};
	static char[] middle = {'1','3','7','9'};
	static String num;
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		for(int i = 0; i < 4; i++) {
			num = first[i] + "";
			dfs(1);
		}

	}
	private static void dfs(int len) {

		if(len >= N) {
			if(isPrime(num)) System.out.println(num);				
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(isPrime(num+middle[i])) {
				num += middle[i];
				dfs(len+1);
				num = num.substring(0, num.length()-1);
			}
		}
	}
	
	private static boolean isPrime(String s) {
		
		int number = Integer.parseInt(s);
		
		for(int i = 2, end = (int) Math.sqrt(number); i < end; i++) {
			if(number % i == 0) return false;
		}
		return true;
	}
}