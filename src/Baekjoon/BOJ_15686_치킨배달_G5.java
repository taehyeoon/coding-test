package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
시작 시간 : 24-01-31 13:50
종료 시간 : 24-01-31 14:40
실행시간 : 152ms 

고려사항
1. 전체 치킨집의 위치를 Point로 저장
2. 전체 치킨집의 개수에서 M개의 치킨집을 조합을 이용하여 구한다
3. 구해진 조합(치킨집 리스트)을 통해 각 집의 치킨거리의 합을 계산
4. 모든 집의 치킨거리의 합과 ans값을 비교하여 최소값을 ans에 할당
*/

public class BOJ_15686_치킨배달_G5 {

	static int N, M, ans = Integer.MAX_VALUE;
	static ArrayList<Point> home;
	static ArrayList<Point> chickPlace;
	static Point[] chickResult;
	
	static class Point{
		int i, j;
		public Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		chickResult = new Point[M];
		chickPlace = new ArrayList<>(13);
		home = new ArrayList<>();
		
		for(int h = 0; h < N; h++) {
			st = new StringTokenizer(br.readLine());
			for(int w = 0; w < N; w++) {
				int val = Integer.parseInt(st.nextToken());
				if(val == 1) 		home.add(new Point(h, w));
				else if(val == 2)   chickPlace.add(new Point(h, w));
			}
		}

		comb(0, 0);

		System.out.println(ans);
	}
	private static void comb(int depth, int idx) {

		if(depth == M) {
			calcPath();
			return;
		}
		

		for(int it = idx; it < chickPlace.size(); it++) {
			chickResult[depth] = chickPlace.get(it);				
			comb(depth+1, it+1);
		}
	}

	private static void calcPath() {
		
		int totalLength = 0;
		
		for(Point h : home) {
			int homeToChick = Integer.MAX_VALUE;
			for(int i = 0; i < M; i++) {
				int l = Math.abs(h.i - chickResult[i].i) + Math.abs(h.j - chickResult[i].j);
				homeToChick = Math.min(homeToChick, l);

			}
			totalLength += homeToChick;
		}
		
		ans = Math.min(ans, totalLength);
		
	}
	
	
}
