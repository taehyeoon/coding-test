package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-12 22:50
종료 시간 : 24-05-12 23:06
실행 시간 : 2884ms
메 모 리 : 342412KB
*/

public class BOJ_2170_선긋기_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[][] lines = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(lines, ((o1, o2) -> {
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        }));

        int ans = 0;
        int end = -1_000_000_000;
        for (int i = 0; i < n; i++) {
            int s = lines[i][0], e = lines[i][1];

            if(e <= end) continue;

            if(s > end){
                ans += e-s;
                end = e;
            }else{
                ans += Math.max(0, e-end);
                end = Math.max(end, e);
            }
        }

        System.out.println(ans);

    }
}