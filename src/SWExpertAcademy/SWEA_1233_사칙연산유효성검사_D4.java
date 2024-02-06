package coding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-06 15:45
종료 시간 : 24-02-06 
실행시간 : 170ms
메 모 리 : 19456KB

고려사항
문자열을 문제에서 기준에 맞게 유효성검사를 하였습니다

*/

public class SWEA_1233_사칙연산유효성검사_D4 {

	static int N;
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc = 1; tc <= 10; tc++) {
			String line = br.readLine();
			N = Integer.parseInt(line);
			
			boolean error = false;
			for(int it = 0; it < N; it++) {
				if(error) {
					br.readLine();
					continue;
				}
				
				String[] input = br.readLine().split(" ");
				if(!isValid(input)) {
					error = true;
				}
			}
			System.out.printf("#%d %d%n", tc, error? 0:1);
		}
		
	}
	private static boolean isValid(String[] str) {
		
		if(str.length == 4) {
			if(!isOp(str[1])) return false;
			
			int p = Integer.parseInt(str[0]);
			int c1 = Integer.parseInt(str[2]);
			int c2 = Integer.parseInt(str[3]);
			
			if(c1/2 != p || c2/2 != p) return false;
		}else if(str.length == 2) {
			if(isOp(str[1])) return false;
		}
		
		return true;
	}
	
	private static boolean isOp(String op) {
		if(op.length() != 1) return false;
		if(op.compareTo("+") == 0 || op.compareTo("-") == 0 || op.compareTo("*") == 0 || op.compareTo("/") == 0) return true;
		return false;
	}
}