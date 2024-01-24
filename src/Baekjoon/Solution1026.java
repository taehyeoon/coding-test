package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


/*
백준 보물 1026 S4
시작 시간 : 24-01-23 10:10
종료 시간 : 24-01-23 10:50
실행시간 : 84ms


고려사항
두 배열간의 곱이 최소가 되기 위해서는 
가장 큰값과 가장 작은 값끼리 곱셈을 진행해야한다

-> Integer 배열에 두 배열을 저장하고
A 배열은 오름차순, B배열은 내림차순 정렬하여 각 인덱스별 곱의 합을 구한다
*/

public class Solution1026 {

	static int N;
	static Integer[] A, B;
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A = new Integer[N];
		B = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			B[i] = Integer.parseInt(st.nextToken());
		
		
		Arrays.sort(A, Collections.reverseOrder());
		Arrays.sort(B);

		int sum = 0;
		for(int i = 0; i < A.length; i++) {
			sum += A[i] * B[i];
		}
		
		System.out.println(sum);
	}
}
