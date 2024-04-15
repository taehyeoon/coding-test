package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-16 01:15
종료 시간 : 24-04-16 01:59
실행 시간 : 372ms
메 모 리 : 65024KB
*/

public class BOJ_16724_피리부는사나이_G3 {


    static int H, W;
    static int[][] dirMap;

    static int[] parents;
    static int[][] delta = {{-1,0}, {0,1}, {1,0}, {0,-1}}; // 상우하좌

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        parents = new int[H*W];
        for (int i = 0; i < H*W; i++) {
            parents[i] = i;
        }


        dirMap = new int[H][W];
        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                char c = line.charAt(j);

                switch (c){
                    case 'U': dirMap[i][j] = 0; break;
                    case 'R': dirMap[i][j] = 1; break;
                    case 'D': dirMap[i][j] = 2; break;
                    case 'L': dirMap[i][j] = 3; break;
                }
            }
        }
    }

    private static int find(int v){
        if(v == parents[v]) return v;

        return parents[v] = find(parents[v]);
    }

    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot)  return false;

        if(aRoot < bRoot) parents[bRoot] = aRoot;
        else parents[aRoot] = bRoot;

        return true;
    }
    public static void main(String[] args) throws IOException {

        input();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {

                int cur = i*W+j;
                int dir = dirMap[i][j];

                int ni = i + delta[dir][0];
                int nj = j + delta[dir][1];

                if(ni < 0 || nj < 0 || ni >= H || nj >= W) continue;

                union(cur, ni*W+nj);
            }
        }


        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                set.add( find(i*W+j));
            }
        }
        System.out.println(set.size());
    }
}