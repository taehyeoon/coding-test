package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.sun.org.apache.xpath.internal.operations.Gt;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_19535_ㄷㄷㄷㅈ_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        List[] adj = new List[N + 1];

        for (int i = 0; i < N + 1; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
            edges.add(new int[] {a, b});
        }

        long dTree = 0;
        for (int i = 0; i < N - 1; i++) {
            int[] edge = edges.get(i);
            int a = edge[0];
            int b = edge[1];
            dTree += (long)(adj[a].size() - 1) * (adj[b].size() - 1);
        }

        long GTree = 0;
        for (int nodeNum = 1; nodeNum < N + 1; nodeNum++) {

            int n = adj[nodeNum].size();
            if (n >= 3) {
                GTree += (long)n * (n - 1) * (n - 2) / 6;
            }
        }

        if (dTree > GTree * 3) {
            System.out.println("D");
        } else if (dTree < GTree * 3) {
            System.out.println("G");
        } else {
            System.out.println("DUDUDUNGA");
        }
    }
}