package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17951_G3 {

	static int K, N;
	static int[] scores;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int sum = 0;
		scores = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
			sum += scores[i];
		}

		int lo = 0, hi = sum+1;
		while (lo + 1 < hi) {
			int mid = (lo+hi) / 2;

			if(check(mid) >= K){
				lo = mid;
			}else {
				hi = mid;
			}
		}

		System.out.println(lo);
	}

	private static int check(int s) {

		int val = 0;
		int groupCnt = 0;
		for (int i = 0; i < N; i++) {
			val+=scores[i];

			if(val >= s){
				groupCnt++;
				if(groupCnt > K){
					break;
				}
				val = 0;
			}
		}

		return groupCnt;
	}
}