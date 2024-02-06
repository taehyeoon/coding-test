package coding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 가르침 1062 G4
시작 시간 : 24-01-31 15:55
종료 시간 : 24-01-31 
실행시간 : 199ms
메 모 리 : 28168KB

고려사항
*/
public class SWEA_9229_한빈이와SpotMart_D3 {

	public static int TC, N, M, maxVal;
	public static int[] arr;
	public static boolean[] isVisited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= TC; tc++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			isVisited = new boolean[N];
			maxVal = -1;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			combi(0, 0, 0);
		
			System.out.printf("#%d %d%n",tc, maxVal);
		}
	}
	private static void combi(int cnt, int start, int sum) {

		if(cnt == 2) {
			if(sum <= M)
				maxVal = Math.max(maxVal, sum);
			return;
		}
		
		for(int i = start; i < N; i++) {
			combi(cnt+1, i+1, sum + arr[i]);
		}
	}
}
