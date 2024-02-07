package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/*
시작 시간 : 24-02-07 23:30
종료 시간 : 24-02-08 00:10
실행시간 : 220ms
메 모 리 : 18252KB

고려사항
각 알파벳이 가지는 가치를 숫자로 환산하였습니다.
예를 들어 AB라는 문자열이 있는 경우, A의 가치는 10이며 B의 가치는 1입니다
모든 문자열을 각 자리끼리 합쳤을 때 각 문자의 가치를 바탕으로 내림차순 정렬 후
가장 가치가 높은 순서대로 9,8,7 ...으로 할당하였습니다.
최종적으로 각 알파벳에 할당된 숫자 * 알파벳의 가치 의 합을 구하였습니다.
*/

public class BOJ_1339_단어수학_G4 {
	static class Alpha{
		int value;
		int toInt;
	}
	static int N;
	static String[] arr;
	static Alpha[] alphabetToInt = new Alpha[26];
	public static void main(String[] args) throws IOException {

		System.setIn(Files.newInputStream(Paths.get("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0; i < 26; i++) alphabetToInt[i] = new Alpha();

		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		for(int i = 0; i < N; i++) arr[i] = br.readLine();

        for (String s : arr) {
            int val = (int) Math.pow(10, s.length() - 1);
            for (char c : s.toCharArray()) {
                alphabetToInt[c - 'A'].value += val;
                val /= 10;
            }
        }

		Arrays.sort(alphabetToInt, (o1, o2) -> o2.value - o1.value);

		int toInt = 9;
		for(int i = 0; i < 10; i++){
			alphabetToInt[i].toInt = toInt--;
		}

		int sum = 0;
		for(int i = 0; i < 26; i++){
			sum += alphabetToInt[i].toInt * alphabetToInt[i].value;
		}

		System.out.println(sum);
	}
}