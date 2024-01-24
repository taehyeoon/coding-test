package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/*
백준 잃어버린괄호 1541 S2
시작 시간 : 24-01-23 09:30
종료 시간 : 24-01-23 10:10
실행시간 : 80ms


고려사항
처음 마이너스가 나오기 직전까지는 sum에 숫자를 더해준다
한번 마이너스가 나오면 그 이후 숫자는 모두 빼준다
*/

public class Solution1541 {

	static String str;
	static ArrayList<Integer> nums = new ArrayList<>();
	static ArrayList<Character> ops = new ArrayList<>();
 	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();
		String charNum = "";
		
		// 입력
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '+' || c == '-') {
				nums.add(Integer.parseInt(charNum));
				charNum = "";
				ops.add(c);
			} else {
				charNum += c;
			}
		}
		nums.add(Integer.parseInt(charNum));

		
		int minSum = nums.get(0);
		boolean hasMinus = false;
		for(int i = 0; i < ops.size(); i++) {
			if(!hasMinus) hasMinus = ops.get(i) == '-' ? true : false;
			
			if(hasMinus) minSum -= nums.get(i+1);
			else minSum += nums.get(i+1);
		}

		System.out.println(minSum);
	}
}
