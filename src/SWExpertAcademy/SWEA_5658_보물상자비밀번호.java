package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
실행 시간 : 121ms
메 모 리 : 20112KB
*/

public class SWEA_5658_보물상자비밀번호 {

	static int TC, N, K;
	static String line;

	private static long makeNumber(String str) {

		char[] list = str.toCharArray();

		int result = 0;
		int idx = 0;
		for(int i = list.length - 1; i >= 0; i--) {

			if(list[i] >= '0' && list[i] <= '9')
				result += (int)Math.pow(16, idx) * (list[i] - '0');
			else
				result += (int)Math.pow(16, idx) * (list[i] - 'A' + 10);
			idx++;
		}


		return result;
	}


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;



		TC = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= TC; tc++) {
			PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int cell = N/4;

			line = br.readLine();

			line = line.concat(line.substring(0, cell));

			for(int slide = 0; slide < cell; slide++) {
				for(int i = 0; i < 4; i++) {

					String password = line.substring(slide + cell*i, slide + cell*(i+1));
					if(!pq.contains(password)) pq.offer(password);
				}
			}

			for(int i = 0; i < K-1; i++) {
				pq.poll();
			}


			sb.append(String.format("#%d %s%n", tc, makeNumber(pq.peek())));
		}

		System.out.print(sb);
	}
}