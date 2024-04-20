package SWExpertAcademy.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-04-20 11:13
종료 시간 : 24-04-20 11:18
실행 시간 : 237ms
메 모 리 : 58956KB
*/

public class SWEA_b_이진수표현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			if((M & ((1 << N) - 1)) == ((1<<N) - 1)){
				sb.append(String.format("#%d %s\n", tc, "ON"));
			}else{
				sb.append(String.format("#%d %s\n", tc, "OFF"));
			}

		}
		System.out.println(sb);
	}
}
