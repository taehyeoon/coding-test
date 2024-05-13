package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-13 23:55
종료 시간 : 24-05-14 00:26
실행 시간 : 180ms
메 모 리 : 15296KB
*/

public class BOJ_2937_블록정리_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, upperStone;
    static int[][] accSum, map;
    static List<int[]> blocks = new ArrayList<>();

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        accSum = new int[N+1][N+1];
        map = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(map[r][c] == 1) upperStone++;
            map[r][c] = 1;
        }
    }

    private static void getBlock(int x){

        int end = (int)Math.ceil(Math.sqrt(x));
        for (int i = 1; i <= end; i++) {
            if(x % i == 0){
                blocks.add(new int[]{i, x/i});
                blocks.add(new int[]{x/i, i});
            }
        }
        if(end*end == x){
            blocks.remove(blocks.size()-1);
        }

    }
    public static void main(String[] args) throws IOException {

        input();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                accSum[i][j] = accSum[i][j-1] + accSum[i-1][j] + map[i][j] - accSum[i-1][j-1];
            }
        }

        getBlock(M);

        int suff = M;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int[] b : blocks){
                    int rbi = i+b[0]-1, rbj = j+b[1]-1;
                    if(rbi > N || rbj > N) continue;
                    int numOfOne = accSum[rbi][rbj] - accSum[rbi][j-1] - accSum[i-1][rbj] + accSum[i-1][j-1];
                    suff = Math.min(suff, M - numOfOne);
                }
            }
        }

        System.out.println(suff);
    }
}