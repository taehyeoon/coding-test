package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1440 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String input = br.readLine();
		String[] inputs = {input.substring(0, 2),
		input.substring(3, 5),
			input.substring(6, 8)};

		// HH, MM, SS
		boolean[] avaHour = new boolean[3];
		boolean[] avaRest = new boolean[3];


		for (int i = 0; i < 3; i++) {
			int val = Integer.parseInt(inputs[i]);

			if(val >= 1 && val <= 12) {
				avaHour[i] = true;
			}

			if(val >= 0 && val <= 59){
				avaRest[i] = true;
			}
		}

		int ans = 1;
		boolean isHourZero = false;
		for (int i = 0; i < 3; i++) {
			int val = avaHour[i] ? 1 : 0;
			int valRest = avaRest[i] ? 2 : 0;

			if(val == 1) isHourZero = true;
			if(val + valRest == 0){
				System.out.println(0);
				return;
			}else{
				ans *= (val+valRest);
			}
		}

		if(isHourZero){
			System.out.println(ans);

		}else{
			System.out.println(0);
		}
	}
}