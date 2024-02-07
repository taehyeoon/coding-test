package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/*
시작 시간 : 24-02-07 22:50
종료 시간 : 24-02-07 23:05
실행시간 : 340ms
메 모 리 : 24688KB

고려사항
로프를 오름차순 정렬한 뒤, 오른쪽으로 순회하며,
k번째 로프를 포함하는 경우 최대 중량을 계산하였습니다.
k번째 로프를 포함할 때는, k~N-1번쨰까지 모든 로프를 사용하는 경우가 최대입니다.
*/

public class BOJ_2217_로프_S4 {

	static int N;
	static Integer[] arr;

	public static void main(String[] args) throws IOException {

		System.setIn(Files.newInputStream(Paths.get("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new Integer[N];
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		int max = 0;
		for(int i = 0; i < N; i++){
			max = Math.max(max, arr[i] * (N - i));
		}
		System.out.println(max);
	}
}