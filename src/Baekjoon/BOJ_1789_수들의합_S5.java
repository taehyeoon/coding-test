package coding.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-06 12:00
종료 시간 : 24-03-06 12:10
실행 시간 : 80ms
메모리 : 11508KB
 */

public class BOJ_1789_수들의합_S5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		long S = Long.parseLong(br.readLine());
		
		long i = (long) Math.sqrt(S);
		while(true) {
			long sum = (i*(i+1)) / 2; 
			if(sum == S) {
				System.out.println(i);
				return;
			}
			
			if(sum > S) {
				System.out.println(i-1);
				return;
			}
			i++;
		}
	}
}