package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 N-Queen 9663 G4
시작 시간 : 24-01-29 14:20
종료 시간 : 24-01-29 15:40
실행시간 : 2128ms


고려사항
가장 상단의 가로줄 부터 한줄씩 내려오며 탐색하였습니다

놓을 수 있는 곳 : 해당 칸의 값이 0
놓을 수 없는 곳 : 해당 칸의 값이 1이상

1. k번째 줄을 탐색할 때, k번째 줄에서 놓을 수 있는 위치 중 하나에 퀸을 놓습니다.
2. 나머지 놓은 위치를 기준으로 k+1~N-1번째 줄까지 놓을수 없게되는 위치에 +1을 합니다.
3. k의 값이 N이 되는 경우, 마지막 줄까지 성공적으로 배치한 것을 의미하므로 정답+1을 합니다
4. dfs에서 빠져나온뒤 이전에 방문 불가로 체크한 칸의 값들을 -1합니다.
5. 모든 메소드가 종료된 후 정답을 출력합니다.
*/

public class Solution9663 {

	static int[][] data;
	static int N;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		
		dfs(0);
		
		System.out.println(ans);
	}

	private static void dfs(int depth) {
		
		// 마지막 줄까지 통과한 경우, 정답++
		if(depth == N) {
			ans++;
			return;
		}
		
		for(int h = 0; h < N; h++) {
			if(data[depth][h] == 0) {
				
				// 현재 가로줄 기준 아래 줄부터 놓을 수 없는 자리 체크
				for(int tempDep = depth+1, side = 1; tempDep < N; tempDep++, side++) {
					data[tempDep][h]++;
					if(h-side >= 0) data[tempDep][h-side]++;
					if(h+side < N) data[tempDep][h+side]++;
				}
				
				// 다음 아래줄 탐색 시작
				dfs(depth+1);
				
				// 체크 원상복구
				for(int tempDep = depth+1, side = 1; tempDep < N; tempDep++, side++) {
					data[tempDep][h]--;
					if(h-side >= 0) data[tempDep][h-side]--;
					if(h+side < N) data[tempDep][h+side]--;
				}
			}
		}
	}
}
