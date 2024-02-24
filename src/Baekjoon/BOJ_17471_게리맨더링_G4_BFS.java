package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-02-21
종료 시간 : 24-02-21
실행시간 : 260ms
메 모 리 : 16052KB
*/


public class BOJ_17471_게리맨더링_G4_BFS {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, totalSum, ans = Integer.MAX_VALUE;
	static int[] people;
	static List<Integer>[] link;
	static boolean[] isSelected;

	private static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		// people
		people = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			totalSum += people[i];
		}

		System.out.println(Arrays.toString(people));
		// Link
		link = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			link[i] = new ArrayList<>();
			for (int j = 0; j < num; j++) {
				link[i].add(Integer.parseInt(st.nextToken()));
			}
		}
	}

	private static void subset(int cnt) {

		if(cnt == N+1) {
			List<Integer> red = new ArrayList<>();
			List<Integer> blue = new ArrayList<>();
			for(int i = 1; i <= N; i++) {
				if(isSelected[i]) {
					red.add(i);
				}else {
					blue.add(i);
				}
			}

			return;
		}

		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] = false;
		subset(cnt+1);

	}

	private static boolean solve(List<Integer> list) {

        boolean[] visit = new boolean[N + 1];
		int cnt = 0;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(list.get(0));
		visit[list.get(0)] = true;

		while (!q.isEmpty()) {
//			int cur = q.poll();
//			cnt++;
//
//			for (int i = 0; i < link[cur].size(); i++) {
//
//				int next = (int) lin																																																																k[cur].get(i);
//				if (visit[next]) continue;
//				if (find(next) != find(cur)) continue;
//
//				visit[next] = true;
//				q.offer(next);
//			}
		}

		if (cnt == list.size()) {
			return true;
		}else return false;

	}

	public static void main(String[] args) throws IOException {

		input();
//		subset(1);

		for (int i = 1; i <= N; i++) {
			System.out.println(link[i]);
		}
		System.out.println("ans = " + ans);
		//		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}