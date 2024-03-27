package coding.swea;

import java.io.*;
import java.util.*;


/*
시작 시간 : 24-03-27
종료 시간 : 24-03-27 
실행시간 : 138ms
메 모 리 : 33940KB
*/

public class SWEA_3307_최장증가부분수열_D3 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	private static int lis(int[] a, int n) {
		
		int[] LIS = new int[n];
		
		int max = 0;
		for(int i = 0; i < LIS.length; i++) {
			LIS[i] = 1;
			for(int j = 0; j < i; j++) {
				if(a[j] < a[i] && LIS[i] < LIS[j]+1) {
					LIS[i] = LIS[j] + 1;
				}
			}
			
			if(max < LIS[i]) {
				max = LIS[i];
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) throws IOException{
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int ans = lis(arr, n);
			
			System.out.printf("#%d %d%n", tc, ans);	
		}
	}
}
