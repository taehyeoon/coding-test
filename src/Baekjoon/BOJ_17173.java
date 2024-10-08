package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17173 {

	static int N, M;
	static int[] input;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer( br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[M];
		boolean[] check = new boolean[N+1];

		st = new StringTokenizer( br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			int base = input[i];

			boolean isOverlap = false;
			for(int j = 0; j < i; j++){
				if(base % input[j] == 0){ isOverlap = true; break; }
			}

			if(isOverlap) {
				continue;
			}

			int value = base;
			while(value <= N){
				check[value] = true;
				value += base;
			}
		}

		long sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += check[i] ? i : 0;
		}

		System.out.println(sum);
	}
}