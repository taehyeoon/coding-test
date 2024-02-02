package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-02 19:35
종료 시간 : 24-02-02 19:45
실행 시간 : 76ms
메 모 리 : 11508KB

고려사항
GCD 유클리드호제법을 이용하여 최대공약수를 구했습니다
이후 최대공약수를 이용하여 최소 공배수를 계산했습니다
*/

public class BOJ_2609_최대공약수와최소공배수_B1 {

	static int a, b;
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		if(b > a){
			int temp = a;
			a = b;
			b = temp;
		}
		int gcdVal = gcd(a,b);

		System.out.println(gcdVal);
		System.out.println(a*b/gcdVal);
	}

	private static int gcd(int a, int b) {
		int ta = a, tb = b;
		while(a % b != 0){
			ta = a; tb = b;
			a = tb;
			b = ta % tb;
		}

		return b;
	}
}