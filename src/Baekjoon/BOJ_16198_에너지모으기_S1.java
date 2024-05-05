package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-06 01:00
종료 시간 : 24-05-06 01:11
실행 시간 : 136ms
메 모 리 : 15892KB
*/

public class BOJ_16198_에너지모으기_S1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int ans;
    static List<Integer> data = new ArrayList<>();

    private static void dfs(int n, int score){
        if(n == 2){
            ans = Math.max(ans, score);
            return;
        }

        for (int i = 1; i < n-1; i++) {

            int newScore = score + data.get(i-1) * data.get(i+1);
            int cur = data.get(i);
            data.remove(i);
            dfs(n-1, newScore);
            data.add(i, cur);
        }
    }
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data.add(Integer.parseInt(st.nextToken()));
        }

        dfs(N, 0);

        System.out.println(ans);
    }
}