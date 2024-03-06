package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
시작 시간 : 24-03-06 18:40
종료 시간 : 24-03-06 18:55
실행 시간 : 204ms / 실패
메 모 리 : 18092KB
*/

public class BOJ_1911_흙길보수하기_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, L, first = Integer.MAX_VALUE, last;
    //    static boolean[] water = new boolean[1_000_000_001];
    static List<int[]> water = new ArrayList<>();
    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            water.add(new int[]{s, e-1});
        }
    }

    public static void main(String[] args) throws IOException {

        input();
        water.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int fill = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int s = water.get(i)[0];
            int e = water.get(i)[1];

            if(fill >= e) continue;

            if(fill < s) fill = s-1;

            int bridgeN = (e-fill) / L;
            if((e-fill) % L != 0) bridgeN++;

            cnt += bridgeN;
            fill += L * bridgeN;
        }

        System.out.println(cnt);
    }
}