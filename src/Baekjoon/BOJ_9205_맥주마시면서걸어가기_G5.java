package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-07 20:50
종료 시간 : 24-02-07 21:20
실행 시간 : 164ms
메 모 리 : 17708KB

고려사항
시작 위치는 집에서 출발하며, 현재 위치를 기준으로 반경 1000거리 안에 편의점이 없다면, sad를 출력하고,
편의점이 있다면, 반복적으로 다음 편의점, 혹은 페스티벌 위치를 갈수 있는지 판단하였습니다.
DFS로 풀이하는 경우에는 시간초과가 발생하며, BFS로 접근해야하는 문제였습니다.
*/

public class BOJ_9205_맥주마시면서걸어가기_G5 {

	static class Pos{
		int x, y, id;

		public Pos(int x, int y, int id) {
			super();
			this.x = x;
			this.y = y;
			this.id = id;
		}
	}

	static int TC, N;
	static Pos home, rock;
	static Pos[] stores;
	static boolean[] isVisited;

	static StringBuilder sb;
	static StringTokenizer st;

	private static void input() throws IOException {
		System.setIn(Files.newInputStream(Paths.get("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < TC; tc++) {
			N = Integer.parseInt(br.readLine());
			stores = new Pos[N];
			isVisited = new boolean[N];

			// home
			st = new StringTokenizer(br.readLine());
			home = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),-1);

			// store
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				stores[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
			}

			// rock
			st = new StringTokenizer(br.readLine());
			rock = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),-1);

			// logic
			if(solution()) sb.append("happy");
			else sb.append("sad");
			sb.append("\n");
		}
	}

	private static boolean solution() {

		Queue<Pos> q = new LinkedList<>();
		q.add(home);

		while(!q.isEmpty()){
			Pos cur = q.poll();
			if(canGo(cur, rock)) return true;
			if(cur.x != home.x || cur.y != home.y) isVisited[cur.id] = true;

            for (Pos store : stores) {
                if (isVisited[store.id]) continue;
                if (!canGo(cur, store)) continue;

                q.add(store);
            }
		}
		return false;
	}

	private static boolean canGo(Pos cur, Pos target) {
		return Math.abs(cur.x-target.x) + Math.abs(cur.y-target.y) <= 1000;
	}

	public static void main(String[] args) throws IOException {
		input();
		System.out.print(sb);
	}
}