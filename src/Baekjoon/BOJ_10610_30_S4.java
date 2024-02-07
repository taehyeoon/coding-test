package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
시작 시간 : 24-02-07 22:10
종료 시간 : 24-02-07 22:40
실행시간 : 120ms
메 모 리 : 14912KB

고려사항
입력값의 크기가 10^5개의 숫자이기 때문에, int나 long이 아닌 String으로 받아야합니다
30의 배수를 만족하기 위해서는 다음 2가지 조건을 동시에 만족해야합니다
1. 0을 1개이상 포함할 것
2. 모든 자리수의 합이 3의 배수일 것
2가지 조건을 체크하여 큰 숫자부터 좌측에 배치하여 최대인 30의 배수를 생성하였습니다
*/

public class BOJ_10610_30_S4 {

	static int[] arr = new int[10];
	public static void main(String[] args) throws IOException {

		System.setIn(Files.newInputStream(Paths.get("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		for(char c : line.toCharArray()) arr[c-'0']++;

		System.out.println(solution());
	}

	private static String solution() {

		if(arr[0] == 0) return "-1";

		int sum = 0;
		for(int i = 1; i < 10; i++){
			sum += i * arr[i];
		}
		if(sum % 3 != 0) return "-1";

		StringBuilder sb = new StringBuilder();
		for(int i = 9; i >= 0; i--){
			for(int iter =0; iter < arr[i]; iter++) sb.append(i);
		}
		return sb.toString();
	}
}