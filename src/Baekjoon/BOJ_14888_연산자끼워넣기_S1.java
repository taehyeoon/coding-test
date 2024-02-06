package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-05 21:30
종료 시간 : 24-02-05 22:00
실행 시간 : 108ms
메 모 리 : 13876KB

고려사항
조합을 이용하여 +,-,*,/의 모든 조합을 구한 뒤, 각 조합마다 값을 구하여
최대 최소 값을 비교하였습니다.
*/

public class BOJ_14888_연산자끼워넣기_S1 {

	static final int PLUS = 1;
	static final int MINUS = 2;
	static final int MUL = 3;
	static final int DIV = 4;
	static int N, opNum, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static int[] nums;
	static int plus, minus, mul, div;
	static int[] result;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		opNum = N-1;
		nums = new int[N];
		result = new int[opNum];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		plus = Integer.parseInt(st.nextToken());
		minus = Integer.parseInt(st.nextToken());
		mul = Integer.parseInt(st.nextToken());
		div = Integer.parseInt(st.nextToken());

		combiPlus(0, 0);

		System.out.println(max);
		System.out.println(min);
	}

	private static void combiPlus(int cnt, int start) {
		if (cnt == plus){
			combiMinus(0,0);
			return;
		}

		for(int i = start; i < opNum; i++){
			if(result[i] != 0) continue;
			result[i] = PLUS;
			combiPlus(cnt+1, i+1);
			result[i] = 0;
		}
	}

	private static void combiMinus(int cnt, int start) {
		if (cnt == minus){
			combiMul(0,0);
			return;
		}

		for(int i = start; i < opNum; i++){
			if(result[i] != 0) continue;
			result[i] = MINUS;
			combiMinus(cnt+1, i+1);
			result[i] = 0;
		}
	}

	private static void combiMul(int cnt, int start) {
		if (cnt == mul){
			combiDiv(0,0);
			return;
		}

		for(int i = start; i < opNum; i++){
			if(result[i] != 0) continue;
			result[i] = MUL;
			combiMul(cnt+1, i+1);
			result[i] = 0;
		}
	}

	private static void combiDiv(int cnt, int start) {
		if (cnt == div){
			calc();
			return;
		}

		for(int i = start; i < opNum; i++){
			if(result[i] != 0) continue;
			result[i] = DIV;
			combiDiv(cnt+1, i+1);
			result[i] = 0;
		}
	}

	private static void calc() {

		int val = nums[0];
		for(int i = 0; i < opNum; i++){
			switch (result[i]){
				case PLUS:
					val += nums[i+1];
					break;
				case MINUS:
					val -= nums[i+1];
					break;
				case MUL:
					val *= nums[i+1];
					break;
				case DIV:
					if(val < 0) val = -((-val)/nums[i+1]);
					else val /= nums[i+1];
					break;
			}
		}

		max = Math.max(max, val);
		min = Math.min(min, val);

	}


}