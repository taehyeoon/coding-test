package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-18 00:07
종료 시간 : 24-05-18 00:55
실행 시간 : 312ms
메 모 리 : 20076KB
*/

public class BOJ_14595_동방프로젝트large_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] merge;

    private static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        merge = new int[M][];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            merge[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
    }
    public static void main(String[] args) throws IOException {
        input();

        if(M == 0){
            System.out.println(N);
            return;
        }
        Arrays.sort(merge, ((o1, o2) -> {
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            else return o1[1]- o2[1];
        }));

        int cnt = merge[0][0];
        int end = merge[0][1];
        for (int i = 1; i < M; i++) {
            if(merge[i][0] > end){
                cnt += merge[i][0] - end;
            }
            end = Math.max(end, merge[i][1]);
        }
        cnt += N - end;
        System.out.println(cnt);
    }
}