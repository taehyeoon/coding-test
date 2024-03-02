package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-01 21:00
종료 시간 : 24-03-01 21:50
실행 시간 : 114ms
메 모 리 : 20744KB
*/

public class SWEA_4013_특이한자석_모의 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int TC, K;
	static int[][] gear;
	static int[][] cmds;
	static boolean[] rotated;

	private static void input() throws IOException{
		K = Integer.parseInt(br.readLine());

		gear = new int[5][8];

		for (int i = 1; i <= 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 8; j++) {
				gear[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cmds = new int[K][2];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			cmds[i][0] = Integer.parseInt(st.nextToken());
			cmds[i][1] = Integer.parseInt(st.nextToken());
		}

	}

	private static void rotate(int curGear, boolean dir){

		int left = curGear-1;
		if(left >= 1 && !rotated[left] && gear[curGear][6] != gear[left][2]){
			rotated[left] = true;
			rotate(left, !dir);
		}

		int right = curGear+1;
		if(right <= 4 && !rotated[right] && gear[curGear][2] != gear[right][6]){
			rotated[right] = true;
			rotate(right, !dir);
		}

		rotateGear(curGear, dir);

	}

	private static void rotateGear(int gearNum, boolean dir){

		int[] g = gear[gearNum];
		// 시계
		if(dir){

			int temp = g[7];
			for (int i = 7; i >= 1; i--) {
				g[i] = g[i-1];
			}
			g[0] = temp;

		// 반시계
		}else{
			int temp = g[0];
			for (int i = 0; i <= 6; i++) {
				g[i] = g[i+1];
			}
			g[7] = temp;
		}
	}
    public static void main(String[] args) throws IOException {
        TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++) {
        	
			input();

			for (int i = 0; i < K; i++) {
				rotated = new boolean[5];
				rotated[cmds[i][0]] = true;
				rotate(cmds[i][0], cmds[i][1] == 1);
			}

			int sum = 0;
			for(int i = 1, expo = 0; i <= 4; i++){

				if(gear[i][0] == 1){
					sum += (int)Math.pow(2, expo);
				}
				expo++;
			}

        	sb.append(String.format("#%d %d%n", tc, sum));
        }

        System.out.print(sb);
    }
}