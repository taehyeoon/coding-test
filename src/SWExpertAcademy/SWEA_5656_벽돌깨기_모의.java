package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
시작 시간 : 24-03-02 18:10
종료 시간 : 24-03-02 20:30
실행 시간 : 2074ms
메 모 리 : 89688KB
*/

public class SWEA_5656_벽돌깨기_모의 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int TC, N, W, H, ans = Integer.MAX_VALUE;
	static int[][] map, originMap;
	static int[] order;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		originMap = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				originMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void shoot(int wPos){
		int hPos = -1;
		for (int i = 0; i < H; i++) {
			if(map[i][wPos] != 0){
				hPos = i;
				break;
			}
		}
		if(hPos == -1) return;
		List<int[]> deleted = new ArrayList<>();

		boolean[][] visited = new boolean[H][W];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{hPos, wPos});
		visited[hPos][wPos] = true;

		while (!q.isEmpty()) {

			int[] cur = q.poll();
			int ci = cur[0], cj = cur[1];
			deleted.add(cur);

			int ni, nj;
			for (int i = 0; i < 4; i++) {
				ni = ci;
				nj = cj;

				for(int go = 0; go < map[ci][cj]; go++, ni += di[i], nj += dj[i]){
					if(ni < 0 || nj < 0 || ni >= H || nj >= W) continue;
					if(visited[ni][nj]) continue;
					if(map[ni][nj] == 0) continue;

					visited[ni][nj] = true;
					q.offer(new int[]{ni, nj});
				}

			}

		}

		for (int[] del : deleted) {
//			System.out.printf("(%d, %d)  ", del[0], del[1]);
			map[del[0]][del[1]] = 0;
		}
	}

	private static boolean fall(int ci, int cj){
		if(ci + 1 == H || map[ci+1][cj] != 0) return false;

		map[ci+1][cj] = map[ci][cj];
		map[ci][cj] = 0;
		return true;
	}

	private static void solve(){

		map = new int[H][W];
		for (int h = 0; h < H; h++) {
			map[h] = Arrays.copyOf(originMap[h], W);
		}

		for(int pos : order){
			shoot(pos);

			for (int w = 0; w < W; w++) {
				for (int h = H-2; h >= 0; h--) {
					int tempH = h;
					while (fall(tempH++, w));
				}
			}
		}

		int cnt = 0;
		for (int h = 0; h < H; h++) {
			for (int w = 0; w < W; w++) {
				if(map[h][w] != 0) cnt++;
			}
		}

		ans = Math.min(ans, cnt);
	}

	private static void per(int cnt){
		if(cnt == N){
//			System.out.println(Arrays.toString(order));

			solve();
			return;
		}

		for(int i = 0; i < W; i++){
			order[cnt] = i;
			per(cnt+1);
		}
	}

	private static void print(){
		System.out.println("===============");

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws IOException {

		TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++) {

			input();
			ans = Integer.MAX_VALUE;
			order = new int[N];
			per(0);

        	sb.append(String.format("#%d %d%n", tc, ans));
        }



        System.out.print(sb);
    }
}