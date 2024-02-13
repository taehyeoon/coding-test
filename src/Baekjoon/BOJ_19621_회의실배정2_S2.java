package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-13 09:10
종료 시간 : 24-02-13 15:00
실행 시간 : 80ms / 실패
메 모 리 : 11572KB

고려사항
연속된 2개의 값을 선택하지 않고, 최대합을 구하는 문제로 생각할 수 있습니다
dp 배열을 생성하여, idx k 위치에 0~k까지의 최대 합을 저장합니다
k번째 값 = max(k번째 선택x, k번째 선택)
      = max(dp[k-1], dp[k-2] + k번째 값)
*/

public class BOJ_19621_회의실배정2_S2 {

	static int N;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws IOException {
				
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[Math.max(2, N)];
		dp = new int[Math.max(2, N)];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken(); st.nextToken();
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solve());
	}

	private static int solve() {
		
		// 두 값을 선택할 수 없는 상태로 최대값을 만드는 것과 동일하다
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		for(int i = 2; i < dp.length; i++) {
			// max(현재 값 선택 안하는 경우, 2번째 전 위치까지합+현재 값)
			dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i]); 
		}
		return dp[N-1];
	}

}