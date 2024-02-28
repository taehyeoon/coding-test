package coding.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
실행 시간 : 264ms
메 모 리 : 91080KB
 */
public class BOJ_12865_평범한배낭_G5 {

	static int N, K;
	static int[][] things;
	static Integer[][] memo;
	private static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		things = new int[N+1][2];
		memo = new Integer[N+1][K+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			things[i] = new int[] {w, v};
		}
	}
	
	private static int dp(int n, int k) {

		if(n == 0) return 0;
		if(memo[n][k] == null) {
			int nextWeight = k - things[n][0];
			
			if(nextWeight < 0) {
				memo[n][k] = dp(n-1, k);
			}
			else {
				memo[n][k] = Math.max(
						dp(n-1, k - things[n][0]) + things[n][1],
						dp(n-1, k));
			}
		}
		return memo[n][k];
	}
	
	public static void main(String[] args) throws IOException{
	
		input();
		
		for(int i = 0; i <= K; i++) memo[0][i] = 0;
		for(int i = 0; i <= N; i++) memo[i][0] = 0;
		
		System.out.println(dp(N, K));
		
	}
}
