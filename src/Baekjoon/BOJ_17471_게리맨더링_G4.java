package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/*
시작 시간 : 24-02-22
종료 시간 : 24-02-22
실행시간 : 112ms / 실패
메 모 리 : 13116KB
*/


public class BOJ_17471_게리맨더링_G4 {

	static class Position{
		int x;
		int peopleNum;

		public Position(int x, int peopleNum) {
			this.x = x;
			this.peopleNum = peopleNum;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, ans = Integer.MAX_VALUE;
	static Position[] positions;
	static ArrayList<Integer>[] link;

	private static void input() throws IOException {
		N = Integer.parseInt(br.readLine());


		positions = new Position[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			positions[i] = new Position(i, Integer.parseInt(st.nextToken()));
		}

		// Link
		link = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			link[i] = new ArrayList<Integer>();
		}
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for(int j = 0; j < size; j++) {
				link[i].add(Integer.parseInt(st.nextToken()));
			}
		}
	}

	public static void main(String[] args) throws IOException {

		input();

		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 1; i <= N/2; i++) {
			combi(1, N, i, A);
		}

		if(ans == Integer.MAX_VALUE){
			ans = -1;
		}

		bw.write(ans + "\n");
		bw.close();
		br.close();
	}

	// 조합
	private static void combi(int start, int n, int r, ArrayList<Integer> A) {
		if (r == 0) {
			solve(A);
			return;
		}

		for (int i = start; i <= n; i++) {
			A.add(i);
			combi(i+1, n, r-1, A);
			A.remove(A.size()-1);
		}
	}

	private static void solve(ArrayList<Integer> A){
		if(!isConnect(positions[A.get(0)].x, A, A.size())){
			return;
		}

		ArrayList<Integer> B = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (A.contains(i)) {
				continue;
			}
			B.add(i);
		}

		if (!isConnect(positions[B.get(0)].x, B, B.size())) {
			return;
		}
		int resultA = 0;

		for (int i = 0; i < A.size(); i++) {
			resultA += positions[A.get(i)].peopleNum;
		}

		int resultB = 0;
		for (int i = 0; i < B.size(); i++) {
			resultB += positions[B.get(i)].peopleNum;
		}

		int result = Math.abs(resultA - resultB);
		ans = Math.min(ans, result);

	}

	private static boolean isConnect(int num, ArrayList<Integer> arr, int size) {
		boolean[] visited = new boolean[N+1];
		visited[num] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(num);

		int count = 1;
		while (!q.isEmpty()) {
			int start = q.poll();

			for (int i : link[start]){
				if (!visited[i] && arr.contains(i)) {
					visited[i] = true;
					count++;
					q.offer(i);
				}

			}
		}

		if(count == size) return true;
		else return false;
	}
}