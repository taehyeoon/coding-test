package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1461_G4 {

	static int N, M;
	static List<Integer> positive = new ArrayList<>();
	static List<Integer> negative = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (a > 0) {
				positive.add(a);
			} else {
				negative.add(-1 * a);
			}
		}

		positive.sort(Collections.reverseOrder());
		negative.sort(Collections.reverseOrder());

		ArrayList<Integer> result = new ArrayList<>();

		int cnt = M;
		for (int i = 0; i < negative.size(); i++) {
			if(cnt == M){
				result.add(negative.get(i));
				cnt = 1;
			}else{
				cnt++;
			}
		}

		cnt = M;
		for (int i = 0; i < positive.size(); i++) {
			if(cnt == M){
				result.add(positive.get(i));
				cnt = 1;
			}else{
				cnt++;
			}
		}


		result.sort(Collections.reverseOrder());
		int sum = result.get(0);
		for (int i = 1; i < result.size(); i++) {
			sum += result.get(i) * 2;
		}

		System.out.println(sum);
	}
}