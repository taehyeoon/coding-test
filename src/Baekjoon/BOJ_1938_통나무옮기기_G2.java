import java.io.*;
import java.util.*;


public class BOJ_1938_통나무옮기기_G2 {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static final int H = 1, V = -1;
	
	static int N;
	static int[] SPos, EPos;
	static int SState, EState;
	static boolean[][] map;
	private static boolean isArrived(int[] stateData) {
		
		return stateData[0] == EPos[0] && stateData[1] == EPos[1] && stateData[2] == EState; 
	}
	
	private static boolean isOut(int i, int j) {
		return i < 0 || j < 0 || i >= N || j >= N;
	}
	
	// [U,D,L,R,T]
	private static boolean[] canMove(int[] cur) {
		
		boolean[] result = new boolean[5];
		int ci = cur[0], cj = cur[1], cState = cur[2];
		
		if(cState == H) {
			// U
			if(isOut(ci-1, cj)) {
				result[0] = false;
			}else {
				if(map[ci-1][cj-1] && map[ci-1][cj] && map[ci-1][cj+1]) {
					result[0] = true;
				}else {
					result[0] = false;
				}
			}
			
			// D
			if(isOut(ci+1, cj)) {
				result[1] = false;
			}else {
				if(map[ci+1][cj-1] && map[ci+1][cj] && map[ci+1][cj+1]) {
					result[1] = true;
				}else {
					result[1] = false;
				}
			}
			
			// L
			if(isOut(ci, cj-2) || !map[ci][cj-2]) {
				result[2] = false;
			}else {
				result[2] = true;
			}
			
			// R
			if(isOut(ci, cj+2) || !map[ci][cj+2]) {
				result[3] = false;
			}else {
				result[3] = true;
			}
			
			// T
			boolean ava = true;
			Find:
			for(int i = -1; i <= 1; i++) {
				for(int j = -1; j <= 1; j++) {
					if(isOut(ci+i, cj+j) || !map[ci+i][cj+j]) {
						ava = false;
						break Find;
					}
				}
			}
			
			result[4] = ava;
			
		}else {
			
			// U
			if(isOut(ci-2, cj) || !map[ci-2][cj]) {
				result[0] = false;
			}else {
				result[0] = true;
			}
			
			// D
			if(isOut(ci+2, cj) || !map[ci+2][cj]) {
				result[1] = false;
			}else {
				result[1] = true;
			}
			
			// L
			if(isOut(ci, cj-1)) {
				result[2] = false;
			}else {
				if(map[ci-1][cj-1] && map[ci][cj-1] && map[ci+1][cj-1]) {
					result[2] = true;
				}else {
					result[2] = false;
				}
			}
			
			// R
			if(isOut(ci, cj+1)) {
				result[3] = false;
			}else {
				if(map[ci-1][cj+1] && map[ci][cj+1] && map[ci+1][cj+1]) {
					result[3] = true;
				}else {
					result[3] = false;
				}
			}			
		
			// T
			boolean ava = true;
			Find:
			for(int i = -1; i <= 1; i++) {
				for(int j = -1; j <= 1; j++) {
					if(isOut(ci+i, cj+j) || !map[ci+i][cj+j]) {
						ava = false;
						break Find;
					}
				}
			}
			
			result[4] = ava;
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		List<int[]> trainB = new ArrayList<>();
		List<int[]> trainE = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for(int j = 0; j < N; j++) {
				char val = line.charAt(j);
				
				if(val == '0') {
					map[i][j] = true;
				}else if(val == '1') {
					map[i][j] = false;
				}else if(val == 'B') {
					map[i][j] = true;
					trainB.add(new int[] {i, j});
				}else if(val == 'E') {
					map[i][j] = true;
					trainE.add(new int[] {i, j});
				}
			}
		}
		

		
		// set start, end pos, state
		SPos = trainB.get(1);
		if(trainB.get(0)[0] == trainB.get(1)[0]) {
			SState = H;
		}else {
			SState = V;
		}
		
		EPos = trainE.get(1);
		if(trainE.get(0)[0] == trainE.get(1)[0]) {
			EState = H;
		}else {
			EState = V;
		}
		
		Set<Integer> visited = new HashSet<>();
		visited.add((SPos[0] * N + SPos[1]) * SState); // 초기상태 방문 체크
		
			
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {SPos[0], SPos[1], SState});
		int moveCnt = 0;
		
		while(!q.isEmpty()) {
			moveCnt++;
			
			int qSize = q.size();
			
			for(int iter = 0; iter < qSize; iter++) {
				
				int[] cur = q.poll();
				
				boolean[] avaMoves = canMove(cur);
				
				// U
				if(avaMoves[0]) {
					
					int ni = cur[0]-1;
					int nj = cur[1];
					int ns = cur[2];	
					int[] next = new int[] {ni, nj, ns};
				
					// 종료 상태이면 종료
					if(isArrived(next)) {
						System.out.println(moveCnt);
						return;
					}
					
					
					int posId = (ni * N + nj) * ns;

					if(!visited.contains(posId)) {
						visited.add(posId);
						
						q.add(next);
					}
				}
				
				// D
				if(avaMoves[1]) {
					
					int ni = cur[0]+1;
					int nj = cur[1];
					int ns = cur[2];	
					int[] next = new int[] {ni, nj, ns};
				
					// 종료 상태이면 종료
					if(isArrived(next)) {
						System.out.println(moveCnt);
						return;
					}
					
					
					int posId = (ni * N + nj) * ns;

					if(!visited.contains(posId)) {
						visited.add(posId);
						
						q.add(next);
					}
				}
				
				// L
				if(avaMoves[2]) {
					
					int ni = cur[0];
					int nj = cur[1]-1;
					int ns = cur[2];	
					int[] next = new int[] {ni, nj, ns};
				
					// 종료 상태이면 종료
					if(isArrived(next)) {
						System.out.println(moveCnt);
						return;
					}
					
					
					int posId = (ni * N + nj) * ns;

					if(!visited.contains(posId)) {
						visited.add(posId);
						
						q.add(next);
					}
				}
				
				// R
				if(avaMoves[3]) {
					
					int ni = cur[0];
					int nj = cur[1]+1;
					int ns = cur[2];	
					int[] next = new int[] {ni, nj, ns};
				
					// 종료 상태이면 종료
					if(isArrived(next)) {
						System.out.println(moveCnt);
						return;
					}
					
					
					int posId = (ni * N + nj) * ns;

					if(!visited.contains(posId)) {
						visited.add(posId);
						
						q.add(next);
					}
				}
				
				// T
				if(avaMoves[4]) {
					
					int ni = cur[0];
					int nj = cur[1];
					int ns = cur[2] * -1;	
					int[] next = new int[] {ni, nj, ns};
				
					// 종료 상태이면 종료
					if(isArrived(next)) {
						System.out.println(moveCnt);
						return;
					}
					
					
					int posId = (ni * N + nj) * ns;

					if(!visited.contains(posId)) {
						visited.add(posId);
						
						q.add(next);
					}
				}
			}
			
		}
	
		System.out.println(0);
	}
}
