package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


/*
백준 ATM 11399
시작 : 24-01-22 16:50
끝 : 24-01-22 17:10
실행시간 : 92ms


고려사항
전체 데이터를 내림차순으로 정렬
전체 최소 합 = sum(k번째 데이터 * (k+1))
k는 0~N-1사이의 값
 */

public class Solution11399 {

	static int N;
	static Integer[] data;
	
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		data = new Integer[N];
		
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(data, Collections.reverseOrder());
		
		int sum = 0;
		for (int i = 0; i < N; i++)
			sum += data[i] * (i + 1);
		
		System.out.println(sum);
	}
}
