package coding.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-05 17:00
종료 시간 : 24-03-05 17:28
실행 시간 : 84ms
메모리 : 11688KB
 */
public class BOJ_23796_2147483648게임_G5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static long[][] map = new long[8][8];
	static char cmd;
	
	private static void input() throws IOException{
		for(int i = 0; i < 8; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 8; j++) {
				map[i][j] = Long.parseLong(st.nextToken());
			}
		}
		
		cmd = br.readLine().charAt(0);
	}
	
	private static void fall() {
		for(int w = 0; w < 8; w++) {
			Queue<Long> col = new ArrayDeque<>();
			for(int h = 7; h >= 0; h--) {
				if(map[h][w] != 0) {
					col.offer(map[h][w]);
				}
				map[h][w] = 0;
			}
			
			int idx = 7;
			while(!col.isEmpty()) {
				long bottom = col.poll();
				if(col.peek() != null && bottom == col.peek()) {
					map[idx][w] = 2*bottom;
					col.poll();
				}else {
					map[idx][w] = bottom;
				}
				idx--;
			}
		}
	}
	
	private static void print() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void turnLeft() {
		long[][] tempMap = new long[8][8];
		for(int i = 0; i < 8; i++) {
			tempMap[i] = Arrays.copyOf(map[i], 8);
		}
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				map[i][j] = tempMap[j][7-i];
			}
		}
	}
	
	private static void turnRight() {
		long[][] tempMap = new long[8][8];
		for(int i = 0; i < 8; i++) {
			tempMap[i] = Arrays.copyOf(map[i], 8);
		}
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				map[i][j] = tempMap[7-j][i];
			}
		}
	}
	
	private static void swap(int w, int a, int b) {
		long temp = map[a][w];
		map[a][w] = map[b][w];
		map[b][w] = temp;
	}
	
	public static void main(String[] args) throws IOException {
		
		input();
		
		if(cmd=='D') {
			fall();
			print();
			return;
		}
		
		if(cmd == 'L') {
			
			turnLeft();
			fall();
			turnRight();
			print();
		}else if(cmd == 'R') {
		
			turnRight();
			fall();
			turnLeft();
			print();
		}else {
			
			for(int w = 0; w < 8; w++) {
				for(int h = 0; h < 4; h++) {
					swap(w, h, 7-h);
				}
			}
			fall();
			for(int w = 0; w < 8; w++) {
				for(int h = 0; h < 4; h++) {
					swap(w, h, 7-h);
				}
			}
			print();
		}
	}
}