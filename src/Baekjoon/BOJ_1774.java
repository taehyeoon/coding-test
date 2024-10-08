package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1774 {

	static int N, M;
	static int[][] spots;

	static int[] uuu;

	private static void init(){
		uuu = new int[N+1];
		for (int i = 1; i <= N; i++) {
			uuu[i] = i;
		}
	}

	private static boolean combine(int a, int b){

		int ua = find(a);
		int ub = find(b);

		if(ua == ub) return false;

		if(ua < ub) uuu[ub] = ua;
		else uuu[ua] = ub;

		return true;
	}

	private static int find(int x){
		if(uuu[x] == x) return x;

		return uuu[x] = find(uuu[x]);
	}


	static class Line implements Comparable<Line> {
		int aIdx, bIdx;
		double dist;
		public Line(int aIdx, int bIdx) {
			this.aIdx = aIdx;
			this.bIdx = bIdx;
			this.dist = Math.sqrt(Math.pow(spots[aIdx][0] - spots[bIdx][0], 2) + Math.pow(spots[aIdx][1] - spots[bIdx][1], 2));
		}

		@Override
		public int compareTo(Line o) {
			return Double.compare(this.dist, o.dist);
		}
	}



	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		spots = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			spots[i][0] = Integer.parseInt(st.nextToken());
			spots[i][1] = Integer.parseInt(st.nextToken());
		}

		init();

		double ans = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			combine(a, b);
		}

		PriorityQueue<Line> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// if(combine(i, j)) continue;

				pq.add(new Line(i, j));
			}
		}

		while(!pq.isEmpty()){
			Line line = pq.poll();

			if(!combine(line.aIdx, line.bIdx)) continue;
			ans += line.dist;
		}

		System.out.printf("%.2f", ans);
	}

}