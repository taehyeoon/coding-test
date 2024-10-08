package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2879 {

	static int N;
	static int[] origin, delta;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N =  Integer.parseInt(br.readLine());
		origin = new int[N];
		delta = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			origin[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			delta[i] = Integer.parseInt(st.nextToken()) - origin[i];
		}


		int status = Integer.compare(delta[0], 0);
		int absMax = Math.abs(delta[0]);

		if(N == 1) {
			return;
		}
		int ans = 0;
		for (int i = 1; i < N; i++) {
			if(delta[i] * status > 0){
				absMax = Math.max(absMax, Math.abs(delta[i]));
			}else if(delta[i] * status < 0){
				ans += absMax;
				absMax = Math.abs(delta[i]);
				status = Integer.compare(delta[i], 0);
			}
		}

		System.out.println(ans+absMax);


	}
}