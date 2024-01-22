package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


/*
백준 동전0 11047 S4
시작 시간 : 24-01-22 17:22
종료 시간 : 24-01-22 17:37
실행시간 : 80ms


고려사항
가장 큰 금액의 동전부터 잔액을 채워 나감
 */

public class Solution11047 {

	static int N, K;
	static Integer[] data;
	static int result;
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new Integer[N];
		
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		}

		if(N == 1) {
			System.out.println(K / N);
			return;
		}
		
		Arrays.sort(data, Collections.reverseOrder());
		
		int leftSum = K;
		int coinIdx = 0;
		
		while(leftSum > 0) {
			if(data[coinIdx] <= leftSum) {
				int numberOfCoin = leftSum / data[coinIdx];
				leftSum -= numberOfCoin * data[coinIdx]; 
				result += numberOfCoin;
			}
			coinIdx++;
			if(coinIdx >= N) coinIdx = N-1;
		}
		
		System.out.println(result);		
	}
}
