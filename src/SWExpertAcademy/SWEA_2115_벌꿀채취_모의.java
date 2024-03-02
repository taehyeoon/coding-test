package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-02 10:20
종료 시간 : 24-03-02 13:00
실행 시간 : 154ms
메 모 리 : 29408KB
*/

public class SWEA_2115_벌꿀채취_모의 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int TC, N, M, C, ans;
	static int[][] map;
	static int[] as = new int[2], bs = new int[2];

	private static void input() throws IOException{

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static int aValue, bValue;
	static boolean[] selected;
	private static void compare(){
		aValue = Integer.MIN_VALUE;
		bValue = Integer.MIN_VALUE;

		selected = new boolean[M];
		subsetA(0);
		selected = new boolean[M];
		subsetB(0);

		ans = Math.max(ans, aValue + bValue);
	}

	private static void subsetA(int cnt){
		if(cnt == M){
			int value = 0;
			int sum = 0;
			for (int i = 0; i < M; i++) {
				int cell = map[as[0]][as[1]+i];
				if(selected[i]) {
					sum += cell;
					value += cell * cell;
				}
			}
			if(sum <= C)
				aValue = Math.max(aValue, value);

			return;
		}

		selected[cnt] = true;
		subsetA(cnt+1);
		selected[cnt] = false;
		subsetA(cnt+1);
	}
	private static void subsetB(int cnt){
		if(cnt == M){
			int value = 0;
			int sum = 0;
			for (int i = 0; i < M; i++) {
				int cell = map[bs[0]][bs[1]+i];
				if(selected[i]){
					sum += cell;
					value += cell * cell;
				}
			}
			if(sum <= C)
				bValue = Math.max(bValue, value);

			return;
		}

		selected[cnt] = true;
		subsetB(cnt+1);
		selected[cnt] = false;
		subsetB(cnt+1);
	}

	private static void solve(){

		// 기준 a와 같은 row
		bs[0] = as[0];
		for(int i = as[1] + M; i <= N-M; i++){
			bs[1] = i;
			compare();
		}

		// 기준 a 위치로부터 아랫줄 시작
		int i = as[0]+1;
		if(i >= N) return;

		for (; i < N; i++) {
			bs[0] = i;
			for (int j = 0; j <= N-M; j++) {
				bs[1] = j;
				compare();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		TC = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= TC; tc++) {
			input();
			ans = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N-M; j++) {
					as = new int[]{i, j};
					solve();
				}
			}

			sb.append(String.format("#%d %d%n", tc, ans));
		}
		System.out.print(sb);
	}
}