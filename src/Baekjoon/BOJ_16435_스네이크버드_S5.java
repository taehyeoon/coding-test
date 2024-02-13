package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 실행시간 : 88ms
// 메모리 : 12064KB

public class BOJ_16435_스네이크버드_S5 {
	
	static int N, warm;
	static int[] foods;
	public static void main(String[] args) throws IOException{
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		warm = Integer.parseInt(st.nextToken());
		foods = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			foods[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(foods);
		
		for(int i = 0; i < N; i++) {
			if(foods[i] > warm) break;
			
			warm++;
		}
		
		System.out.println(warm);
	}
}