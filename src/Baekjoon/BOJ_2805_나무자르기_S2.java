package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-15
종료 시간 : 24-03-30
실행 시간 : 776ms / 실패
메 모 리 : 171988KB
*/

public class BOJ_2805_나무자르기_S2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static long maxTree;
    static long[] tree;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Long.parseLong(st.nextToken());
            maxTree = Math.max(maxTree, tree[i]);
        }
    }

    private static boolean check(long x){

        long sum = 0;
        for (int i = 0; i < N; i++) {
            if(tree[i] > x) sum += tree[i] - x;
        }
        return sum >= M;
    }
    public static void main(String[] args) throws IOException {

        input();

        Arrays.sort(tree);

        long l = -1;
        long h = maxTree+1;
        while (l+1 < h){
            long mid = (l+h)/2;

            if(check(mid)) l = mid;
            else h = mid;
        }

        System.out.println(l);
    }
}