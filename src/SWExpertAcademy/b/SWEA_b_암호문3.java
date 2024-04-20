package SWExpertAcademy.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
시작 시간 : 24-04-20 11:13
종료 시간 : 24-04-20 11:!8
실행 시간 : 237ms
메 모 리 : 58956KB
*/

public class SWEA_b_암호문3 {


	private static LinkedList<Character> getLL(String str){

		LinkedList<Character> result = new LinkedList<>();

		for (char c : str.toCharArray()) {
			result.add(c);
		}

		return new LinkedList<>();
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		
		int TC = 10;
		for(int tc = 1; tc <= TC; tc++) {

			int N = Integer.parseInt(br.readLine());

			LinkedList<LinkedList<Character>> llist = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				LinkedList<Character> secure = new LinkedList<>();
				String str = st.nextToken();

				for(char c : str.toCharArray()){
					secure.add(c);
				}
				llist.add(secure);
			}

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {

				int x, y;
				switch (st.nextToken()){
					case "I":
						x = Integer.parseInt(st.nextToken());
						y = Integer.parseInt(st.nextToken());

						for (int j = x; j < x+y; j++) {
							llist.get(j).addAll(getLL(st.nextToken()));
						}

						break;

					case "D":
						x = Integer.parseInt(st.nextToken());
						y = Integer.parseInt(st.nextToken());

						llist.get(i).addAll(getLL(st.nextToken()));


						break;

					case "A":
						break;
				}
			}

			sb.append(String.format("#%d %s\n", tc, llist.size()));

		}
		System.out.println(sb);
	}
}
