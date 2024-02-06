package coding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-06 11:50
종료 시간 : 24-02-06 
실행시간 : 604ms / 실패
메 모 리 : 31868KB

고려사항
for문을 이용한 구현 문제였습니다.
*/

public class BOJ_16926_배열돌리기1_S1 {

	static int N, M, R;
	static int[][] arr;
	
	
	public static void main(String[] args) throws IOException {
				
		input();
		int row = N;
		int col = M;
		
		for(int rot = 0; rot < Math.min(N, M)/2; rot++) {
			for(int i = 0; i < R; i++) {
				rotate(rot);
			}
		}
		
		print();
	}

	private static void rotate(int x) {

		int temp = arr[x][x];
		
		// 위
		for(int i = x+1; i <= M-x-1; i++) arr[x][i-1] = arr[x][i];
		
		// 오른쪽
		for(int i = x+1; i <= N-1-x; i++) arr[i-1][M-1-x] = arr[i][M-1-x];
		
		// 아래
		for(int i = M-2-x; i >= x; i--) arr[N-1-x][i+1] = arr[N-1-x][i];
		
		// 왼쪽
		for(int i = N-2-x; i >= x; i--) arr[i+1][x] = arr[i][x];
		
		arr[x+1][x] = temp;
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
//				System.out.printf("%d ", arr[i][j]);
			}sb.append("\n");
		}		
		System.out.print(sb);
	}

	private static void input() throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}