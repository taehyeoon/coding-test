package SWExpertAcademy;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-03 15:20
종료 시간 : 24-04-03 17:07
실행시간 : 119ms
메 모 리 : 23920KB
*/


public class SWEA_4013_특이한자석 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static final int L = 6, C = 0, R = 2;
	static int K;
	static int[][] gears;
	static int[][] cmds;
	
	private static void input() throws IOException{
		K = Integer.parseInt(br.readLine());
		
		gears = new int[5][8]; 

		for (int i = 1; i <= 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 8; j++) {
				gears[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		cmds = new int[K][2];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			cmds[i][0] = Integer.parseInt(st.nextToken());
			cmds[i][1] = Integer.parseInt(st.nextToken());
		}
	}
	
	private static void turnGear(List<int[]> turnList) {
		
		for(int[] info : turnList) {
			
			int gn = info[0];
			int dir = info[1];
			
			// CW
			if(dir == 1) {
				int temp = gears[gn][7];
				
				for (int i = 7; i >= 1; i--) {
					gears[gn][i] = gears[gn][i-1];
				}
				gears[gn][0] = temp;
			}
			
			// CCW
			else {
				int temp = gears[gn][0];
				
				for (int i = 0; i <= 6; i++) {
					gears[gn][i] = gears[gn][i+1];
				}
				gears[gn][7] = temp;
			}
			
		}
	}
	
	private static List<int[]> checkGear(int gearNum, int originDir) {
//		어느 톱니바퀴가 돌아야되는 지 판단하기
		List<int[]> turnList = new ArrayList();
		turnList.add(new int[] {gearNum, originDir});
		
		int cg = gearNum;
		int rg = gearNum+1;
		int dir = originDir;
		while(rg <= 4) {
			if(gears[cg][R] == gears[rg][L]) break;
			dir *= -1;
			turnList.add(new int[] {rg, dir});
			cg++; rg++;
		}
		
		cg = gearNum;
		int lg = gearNum-1;
		dir = originDir;
		while(lg >= 1) {
			if(gears[lg][R] == gears[cg][L]) break;
			dir *= -1;
			turnList.add(new int[] {lg, dir});
			cg--; lg--;
		}
		
		return turnList;
	}
	
	private static int calc() {
		
		int ans = 0;
		
		return gears[1][C]*1 + gears[2][C]*2 + gears[3][C]*4 + gears[4][C]*8; 
	}
	public static void main(String[] args) throws IOException {
	
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			input();
			
			for (int i = 0; i < K; i++) {
				
				List<int[]> turnList = checkGear(cmds[i][0], cmds[i][1]);
				
				turnGear(turnList);
			}

			sb.append(String.format("#%d %d%n", tc, calc()));
		}
		System.out.println(sb);
	}
}
