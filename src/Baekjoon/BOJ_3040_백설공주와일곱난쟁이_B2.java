package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 백설공주와일곱난쟁이 3040 B2
시작 시간 : 24-01-31 11:20
종료 시간 : 24-01-31 11:55
실행시간 : 76ms

고려사항
1. 순열을 통해 가능한 모든 7난쟁이의 경우의 수를 구한다
2. 구한 난쟁이의 합이 100이 되는 순간 난쟁이 목록을 출력
*/

public class BOJ_3040_백설공주와일곱난쟁이_B2 {

	static int[] data = new int[9];
	static int[] result = new int[7];
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		for(int it = 0; it < 9; it++) {
			data[it] = Integer.parseInt(br.readLine());
		}
		
		comb(0, 0);
	}

	private static boolean comb(int depth, int idx) {
		if(depth == 7) {
			int sum = 0;
			StringBuilder sb = new StringBuilder();
			
			for(int r : result) {
				sum += r;
				sb.append(r + "\n");
			}
			
			if(sum == 100) {
				System.out.print(sb);
				return true;
			}else 
				return false;
		}
		
		for(int it = idx; it < 9; it++) {
			result[depth] = data[it];
			if(comb(depth+1, it+1)) return true;
		}
		
		return false;
	}
}