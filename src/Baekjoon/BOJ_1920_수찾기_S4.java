package Baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-02 22:10
종료 시간 : 24-02-02 22:20
실행 시간 : 500ms
메 모 리 : 61620KB

고려사항
Map구조를 이용하여 빠른 검색을 활용하였습니다
*/

public class BOJ_1920_수찾기_S4 {

	static int N, M;
	static Map<Long, Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			long key = Integer.parseInt(st.nextToken());
			if(!map.containsKey(key)) map.put(key, 1);
		}

		M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++){
			long key = Integer.parseInt(st.nextToken());
			if(map.containsKey(key)) sb.append(1);
			else sb.append(0);
			sb.append('\n');
		}
		System.out.println(sb);
	}
}