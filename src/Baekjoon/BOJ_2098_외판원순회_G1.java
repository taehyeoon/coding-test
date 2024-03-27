package coding.baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-27
종료 시간 : 24-03-27
실행 시간 : 164ms / 실패
메 모 리 : 17128KB
*/

public class BOJ_2098_외판원순회_G1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int N;
    static int[][] w, dp;
    static final int INF = Integer.MAX_VALUE/2;
    
    private static void input() throws IOException{
    	N = Integer.parseInt(br.readLine());
    	
    	dp = new int[N][1<<N];
    	w = new int[N][N];
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < N; j++) {
    			w[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    }
    
    private static int dfs(int city, int visit) {
    	
    	if(visit == (1 << N) - 1) {
    		// 다시 시작점으로 이동 가능한 경우
    		if(w[city][0] != 0) {
    			return w[city][0];
			// 시작점으로 이동 불가
    		}else {
    			return INF;
    		}
    	}
    	
    	// 이미 계산한 값이면 저장된 값 리턴
    	if(dp[city][visit] != 0) return dp[city][visit];
    	dp[city][visit] = INF;
    	for(int i = 1; i < N; i++) {
    		// 아직 방문하지 않은 노드          &&      해당 노드로 길이 있을 때
    		if((visit & (1<<i)) == 0   &&     w[city][i] != 0) {
    			dp[city][visit] = Math.min(dp[city][visit], // visit하지 않은 도시를 순회하고 다시 city로 온 경우의 비용의 합 
									dfs(i, visit | 1 << i) + w[city][i]);
    		}
    	}
    	
    	return dp[city][visit];
    	
    	
    }
    public static void main(String[] args) throws IOException {
    	
    	input();
    	
    	int res = dfs(0, 1);
    	System.out.println(res);
    }
}