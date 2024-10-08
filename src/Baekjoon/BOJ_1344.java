package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1344 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		double A = Double.parseDouble(br.readLine()) / 100.0;
		double B = Double.parseDouble(br.readLine()) / 100.0;

		int[] iter = {0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18};

		double aSum = 0;
		double bSum = 0;

		for (int i = 0; i < 12; i++) {
			aSum += comb(18, iter[i]) * Math.pow(A, iter[i]) * Math.pow(1.0-A, 18 - iter[i]);
			bSum += comb(18, iter[i]) * Math.pow(B, iter[i]) * Math.pow(1.0-B, 18 - iter[i]);
		}

		System.out.println(1- (aSum * bSum));
	}

	static double[][] dp = new double[19][19];
	private static double comb(int n, int r){
		if(n == r || r == 0){
			return 1;
		}

		if(dp[n][r] == 0){
			dp[n][r] = comb(n-1, r-1) + comb(n-1, r);
		}

		return dp[n][r];
	}

}