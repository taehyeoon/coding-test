package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
시작 시간 : 24-02-28
종료 시간 : 24-02-28 22:45
실행 시간 : 324ms
메 모 리 : 80284KB
*/
public class SWEA_1767_프로세서연결하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int TC, N;
	static int[][] map;
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static List<int[]> innerCoreList;
	static int innerCoreNum;
	static PriorityQueue<int[]> result;

	private static void reset(){
		innerCoreNum = 0;
		innerCoreList = new ArrayList<>();
		result = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
			}
		});
	}

	private static void input() throws IOException{
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val;
				if(val == 1 && i > 0 && j > 0 && i < N-1 && j < N-1) {
					innerCoreList.add(new int[]{i, j});
					innerCoreNum++;
				}
			}
		}
	}

	private static int canConnect(int coreIdx, int dir){

		int wire = 0;

		int ni = innerCoreList.get(coreIdx)[0];
		int nj = innerCoreList.get(coreIdx)[1];
		while(true){
			ni += di[dir];
			nj += dj[dir];

			if(ni < 0 || nj < 0 || ni >= N || nj >= N) return wire;
			if(map[ni][nj] == -1 || map[ni][nj] == 1) return 0;
			wire++;
		}
	}

	private static void connect(boolean doConnect, int coreIdx, int dir){
		// 연결하는 경우 -1로 전선 표시
		// 연결 끊는 경우 0으로 되돌리기
		int write = doConnect ? -1 : 0;

		int ni = innerCoreList.get(coreIdx)[0];
		int nj = innerCoreList.get(coreIdx)[1];

		while(true){
			ni += di[dir];
			nj += dj[dir];

			if(ni < 0 || nj < 0 || ni >= N || nj >= N) return;
			map[ni][nj] = write;
		}
	}
	private static void dfs(int wireLen, int coreIdx, int connectedCore){

		if(coreIdx == innerCoreNum){
			result.offer(new int[]{connectedCore, wireLen});
			return;
		}

		// 현재 core를 skip하는 경우
		dfs(wireLen, coreIdx+1, connectedCore);

		for(int i = 0; i < 4; i++){
			int addedWire = canConnect(coreIdx, i);
			// 연결 불가한 경우
			if(addedWire == 0) continue;

			connect(true, coreIdx, i);
			dfs(wireLen + addedWire, coreIdx+1, connectedCore+1);
			connect(false, coreIdx, i);
		}
	}

	public static void main(String[] args) throws IOException {

		TC = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= TC; tc++) {

			reset();
			input();

			dfs(0,0,0);

			System.out.printf("#%d %d%n", tc, result.peek()[1]);
		}
	}
}
