package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-07 19:30
종료 시간 : 24-02-07 19:45
실행 시간 : 76ms
메 모 리 : 11576KB

고려사항
문제에서 제시한 N의 범위가 작아, 입력받은 색종이마다
색종이 내부를 true 체크하여, 총 true의 개수를 계산하였습니다.
*/

public class BOJ_2563_색종이_S5 {

	static class Paper{
		int x, y;

		public Paper(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static boolean[][] check = new boolean[100][100];
	static Paper[] papers;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		System.setIn(Files.newInputStream(Paths.get("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
		N = Integer.parseInt(br.readLine());
		papers = new Paper[N];
		for(int i =0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			papers[i] = new Paper(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}


		for(int i = 0; i < N; i++){
			Paper p = papers[i];
			for(int h = 0; h < 10; h++){
				for(int w = 0; w < 10; w++){
					check[p.x+w][p.y+h] = true;
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(check[i][j]) cnt++;
			}
		}

		System.out.println(cnt);
	}
}