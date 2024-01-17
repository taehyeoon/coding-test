package pack;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

// 토마토 7576 G5
public class Solution7576  {

    static int n, m; // 세로 가로
    static int days;
    static int[][] mat; // 인풋 배열 저장
    
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    static Queue<Point> q;
    
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        mat = new int[n][m];
        q = new LinkedList<>();
        
        // 데이터 입력
        for(int i = 0; i < n; i++){
        	st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
                if(mat[i][j] == 1) q.add(new Point(i, j));
            }
        }
        	
        System.out.println(bfs());
    }

    private static int bfs() {

        while(!q.isEmpty()){
            Point cur = q.poll();
            int nowI = cur.x;
            int nowJ = cur.y;

            for(int i = 0; i < 4; i++){
                int nextI = nowI + di[i];
                int nextJ = nowJ + dj[i];

                // map 바깥쪽 예외처리
                if(nextI < 0 || nextJ < 0 || nextI >= n || nextJ >= m) continue;

                if(mat[nextI][nextJ] == 0) {
                	// 익은 토마토 추가
                	q.add(new Point(nextI, nextJ));
                	mat[nextI][nextJ] = mat[nowI][nowJ] + 1;
                }
            }
        }
        
        int result = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		if(mat[i][j] == 0) return -1;
        		result = Math.max(result, mat[i][j]);
        	}
        }
        
        if(result == 1) return 0;
        else return result - 1;
    }
}