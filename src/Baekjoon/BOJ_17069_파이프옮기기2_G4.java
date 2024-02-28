package coding.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-28 15:40
종료 시간 : 24-02-28 16:16 
실행시간 : 84ms
메 모 리 : 12000KB
*/

public class BOJ_17069_파이프옮기기2_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    
    static int N;
    static long[][] map;
    static long[][][] memo;
    
    private static void input() throws IOException {
    	N = Integer.parseInt(br.readLine());
    	
    	map = new long[N+1][N+1];
    	memo = new long[N+1][N+1][3];
    	
    	for(int i = 1; i <= N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 1; j <= N; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    }


	public static void main(String[] args) throws IOException {

        input();
        
        memo[1][2][0] = 1;
        
        for(int i = 1; i <= N; i++) {
        	for(int j = 1; j <= N; j++) {
        		
        		if(i == 1 && j == 1) continue;
        		if(i == 1 && j == 2) continue;
        		if(map[i][j] == 1) continue;
        		
        		memo[i][j][0] = memo[i][j-1][0] + memo[i][j-1][1]; // 가로
        		memo[i][j][2] = memo[i-1][j][2] + memo[i-1][j][1]; // 세로
        		
        		if(map[i][j-1] == 1 || map[i-1][j] == 1) continue;
        		memo[i][j][1] = memo[i-1][j-1][0] + memo[i-1][j-1][1] + memo[i-1][j-1][2];
        	}
        }
        
        System.out.println(memo[N][N][0] + memo[N][N][1] + memo[N][N][2]);
        
        bw.close();
        br.close();
    }
}