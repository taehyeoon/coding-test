package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
시작 시간 : 24-02-02 19:10
종료 시간 : 24-02-02 19:30
실행 시간 : 1068ms
메 모 리 : 25224KB

고려사항
시간초과를 피하기 위해서 HashMap을 이용하여 카드가 나타난 빈도수를 저장하였습니다
처음에 가지고 있는 카드 리스트에서
key : 카드번호
value : 해당 카드의 빈도수
로 저장하였습니다.
*/

public class BOJ_10816_숫자카드2_S4 {

	static int M, N;
	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			int key = Integer.parseInt(st.nextToken());
			if(map.containsKey(key)){
				map.put(key, map.get(key)+1);
			}else{
				map.put(key,1);
			}
		}

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer((br.readLine()));
		int[] outputIndices = new int[M];
		for(int i = 0; i < M; i++){
			outputIndices[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++){

			if(map.containsKey(outputIndices[i])) {
				sb.append(map.get(outputIndices[i]));
			}
			else sb.append(0);
			sb.append(' ');
		}

		sb.append('\n');

		System.out.println(sb);
	}
}