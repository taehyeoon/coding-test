package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 실행시간 : 163ms
 * 메모리 : 21688KB
 */
public class SWEA_1952_수영장 {
	
	static int TC;
	static int ans;
	static int[] prices = new int[4];
	static int[] months = new int[13];
	static int[] result = new int[13];
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			ans = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for(int p = 0; p < 4; p++)
				prices[p] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int d = 1; d <= 12; d++)
				months[d] = Integer.parseInt(st.nextToken());
			
			
			dp(1);
			
			ans = Math.min(ans, prices[3]);
			System.out.printf("#%d %d%n", tc, ans);	
		}
		
	}
	private static void dp(int month) {
		
		if(month > 12) {
			int sum = 0;
			for(int d = 1; d <= 12; d++) {
				switch(result[d]) {
				case 0: // 하루
					sum += prices[0] * months[d];
					break;
				case 1: // 1달
					sum += prices[1];
					break;
				case 2: // 3달
					sum += prices[2];
					d += 2;
					break;	
				}
			}
			ans = Math.min(ans, sum); 
			return;
		}
		
		result[month] = 0;
		dp(month+1);
		
		result[month] = 1;
		dp(month+1);
		
		if(month <= 10) {
			result[month] = 2;
			dp(month+3);
		}
	}
	
}

