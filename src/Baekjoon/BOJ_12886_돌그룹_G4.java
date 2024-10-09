package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-08-04 16:50
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_12886_돌그룹_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int ans;
    static boolean[][] visited = new boolean[1501][1501];
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if((a+b+c) % 3 != 0){
            System.out.println(0);
            return;
        }

        dfs(a,b,c);

        System.out.println(ans);
    }

    private static void dfs(int a, int b, int c){
        if(a == b && b == c){
            ans = 1;
            return;
        }

        if(ans == 0) calc(a,b,c);
        if(ans == 0) calc(b,c,a);
        if(ans == 0) calc(a,c,b);
    }

    private static void calc(int a, int b, int origin){
        int small = Math.min(a,b);
        int big = Math.max(a,b);

        if(!visited[2*small][big-small]){
            visited[2*small][big-small] = visited[big-small][2*small] = true;
            dfs(2*small, big-small, origin);
        }
    }
}