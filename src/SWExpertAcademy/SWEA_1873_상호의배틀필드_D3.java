package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간: 24-02-15 19:50
종료 시간: 24-02-15 22:15
실행 시간: 130ms
메 모 리: 22464KB
*/
public class SWEA_1873_상호의배틀필드_D3 {

	static int TC, H, W, N;
	static char[] cmds;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();
	static int head;
	static int[] tank = new int[2];

	private static void input() throws Exception {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				String line = br.readLine();
				for (int j = 0; j < W; j++) {
					char c = line.charAt(j);
					map[i][j] = c;

					if(c == '^' || c == 'v' || c == '<' || c == '>'){
						if(c == '^')      head = 0;
						else if(c == 'v') head = 1;
						else if(c == '<') head = 2;
						else 			  head = 3;
						tank[0] = i;
						tank[1] = j;
					}
				}
			}
			N = Integer.parseInt(br.readLine());
			cmds = br.readLine().toCharArray();

			solve();

			saveResult(tc);
		}
	}

	private static void saveResult(int tc) {
		sb.append(String.format("#%d ", tc));
		for (char[] row : map){
			for(char c : row) sb.append(c);
			sb.append("\n");
		}
	}

	private static void solve() {
		for(int i = 0; i < N; i++){

			if(cmds[i] == 'S') Shoot();
			else MoveTo(cmds[i]);

		}
	}

	private static void MoveTo(char cmd) {
		int ni = tank[0], nj = tank[1];
		char shape = '-';
		if(cmd == 'U')      { ni--; shape = '^'; head = 0; }
		else if(cmd == 'D') { ni++; shape = 'v'; head = 1; }
		else if(cmd == 'L') { nj--; shape = '<'; head = 2; }
		else                { nj++; shape = '>'; head = 3; }

		if(ni >= 0 && nj >= 0 && ni < H && nj < W){
			if(map[ni][nj] == '.'){
				map[tank[0]][tank[1]] = '.'; // 지나온 자리 평지 처리
				tank[0] = ni;
				tank[1] = nj;
			}
		}

		map[tank[0]][tank[1]] = shape;
	}

	private static void Shoot() {
		int bulletI = tank[0], bulletJ = tank[1];
		while(true){
			switch (head){
				case 0: bulletI--; break; // 상
				case 1: bulletI++; break; // 하
				case 2: bulletJ--; break; // 좌
				case 3: bulletJ++; break; // 우
			}
			if(bulletI < 0 || bulletJ < 0 || bulletI >= H || bulletJ >= W) return;

			char block = map[bulletI][bulletJ];
			if(block == '*') {
				map[bulletI][bulletJ] = '.';
				return;
			}

			if(block == '#') return;
		}
	}

	public static void main(String[] args) throws Exception {

		input();
		System.out.println(sb);
	}
}