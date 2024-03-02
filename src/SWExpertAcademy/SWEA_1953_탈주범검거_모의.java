package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-01 21:55
종료 시간 : 24-03-02 03:27
실행 시간 : 151ms
메 모 리 : 26752KB
*/

public class SWEA_1953_탈주범검거_모의 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int TC, H, W, SI, SJ, Time;
	static int[][] map;

	static boolean[][] visited;

	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] pipe = {
			{},
			{0,1,2,3},
			{0,1},
			{2,3},
			{0,3},
			{1,3},
			{1,2},
			{0,2},
	};

	private static void input() throws IOException{

		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		SI = Integer.parseInt(st.nextToken());
		SJ = Integer.parseInt(st.nextToken());
		Time = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static boolean connected(int ai, int aj, int bi, int bj){

		int type = map[ai][aj];
		int vari = pipe[type].length;
		boolean aTob = false;
		for (int i = 0; i < vari; i++) {
			int ni = ai + dir[pipe[type][i]][0];
			int nj = aj + dir[pipe[type][i]][1];
			if(ni == bi && nj == bj) {
				aTob = true;
				break;
			}
		}
		if(!aTob) return false;

		type = map[bi][bj];
		vari = pipe[type].length;
		boolean bToa = false;
		for (int i = 0; i < vari; i++) {
			int ni = bi + dir[pipe[type][i]][0];
			int nj = bj + dir[pipe[type][i]][1];
			if(ni == ai && nj == aj) {
				bToa = true;
				break;
			}
		}

		if(!bToa) return false;

		return true;
	}

	public static void main(String[] args) throws IOException {
		TC = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= TC; tc++) {
			input();
			visited = new boolean[H][W];
			int ans = 0;

			Queue<int[]> q = new ArrayDeque<>();

			visited[SI][SJ] = true;
			q.offer(new int[]{SI, SJ});
			while (!q.isEmpty() && Time > 0) {

				Time--;
				for (int iter = 0, size = q.size(); iter < size; iter++) {

					int[] cur = q.poll();

					int ci = cur[0], cj = cur[1];
					ans++;

					int pipeType = map[ci][cj];
					for (int i = 0, near_num = pipe[pipeType].length; i < near_num; i++) {
						int d = pipe[pipeType][i];
						int ni = ci + dir[d][0];
						int nj = cj + dir[d][1];

						if(ni < 0 || nj < 0 || ni >= H || nj >= W) continue;
						if(map[ni][nj] == 0) continue;
						if(visited[ni][nj]) continue;
						if(!connected(ci, cj, ni, nj)) continue;

						visited[ni][nj] = true;
						q.offer(new int[]{ni, nj});
					}

				}

			}

			sb.append(String.format("#%d %d%n", tc, ans));
		}

		System.out.print(sb);
	}
}