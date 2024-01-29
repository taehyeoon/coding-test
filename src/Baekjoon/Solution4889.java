package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/*
백준 안정적인문자열 4889 S1
시작 시간 : 24-01-29 08:20
종료 시간 : 24-01-29 08:45
실행시간 : 92ms


고려사항
k번째 문자를 탐색하며, k-1번째까지 몇개의 괄호가 열려있는 상태인지 체크합니다.
예를 들어 2개가 열려있는 중, 닫힌 괄호를 만나면 열려있는 괄호의 개수를 1개로 수정합니다.

만약 열려있는 괄호의 수와 미탐색한 괄호의 개수가 같을 경우
나머지 모든 괄호를 }괄호로 변경하는 개수를 정답에 더합니다.
*/

public class Solution4889 {

	static String line;
	static char[] data;
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCaseNum = 1;
		line = br.readLine();
		while(line.toCharArray()[0] != '-') {
			data = line.toCharArray();
			
			boolean mustAllClose = false;
			int openNum = 0;
			int ans = 0;
			int n = data.length;
			
			for(int i = 0; i < n; i++) {
				if(mustAllClose) {
					if(data[i] == '{') {
						ans++;
					}
					continue;
				}
				
				if(openNum == 0 && data[i] == '}') {
					ans++;
					openNum++;
					continue;
				}
				
				if(n-i == openNum) {
					if(data[i] == '{') {
						ans++;
					}
					mustAllClose = true;
					continue;
				}
				
				if(data[i] == '}'){
					openNum--;
				}else if(data[i] == '{') {
					openNum++;
				}
			}
			
			
			System.out.println(testCaseNum + ". " + ans);
			testCaseNum++;
			line = br.readLine();
		}
		
		
	}
}
