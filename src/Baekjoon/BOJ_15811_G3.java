package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_15811_G3 {

	static List<Integer> alphabet = new ArrayList<>();
	static boolean[] isUsed = new boolean[10];
	static boolean findAns;
	static String[] input = new String[3];
	static int[] al2Num = new int[26];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		boolean[] alphabetSelected = new boolean[26];
		for (int i = 0; i < 3; i++) {
			input[i] = st.nextToken();

			for (int j = 0; j < input[i].length(); j++) {
				int idx = input[i].charAt(j) - 'A';
				if(!alphabetSelected[idx]){
					alphabetSelected[idx] = true;
					alphabet.add(idx);
				}
			}
		}

		dfs(0);

		System.out.println(findAns ? "YES" : "NO");
	}

	private static int getNumber(String s){

		int val = 0;

		for(int i = 0; i < s.length(); i++){
			val = val * 10 + al2Num[s.charAt(i) - 'A'];
		}

		return val;
	}

	private static void dfs(int level){

		if(findAns) return;

		if(level == alphabet.size()){
			int[] numbers = new int[3];

			for(int i = 0; i < 3; i++){
				numbers[i] = getNumber(input[i]);
			}

			if(numbers[0] + numbers[1] == numbers[2]){
				findAns = true;
			}
		}else{
			for (int i = 0; i < 10; i++) {

				if(!isUsed[i]){
					isUsed[i] = true;
					al2Num[alphabet.get(level)] = i;
					dfs(level + 1);
					isUsed[i] = false;
				}
			}
		}
	}

}