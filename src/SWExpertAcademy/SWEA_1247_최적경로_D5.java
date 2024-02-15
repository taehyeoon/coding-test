package SWExpertAcademy;

/*
시작 시간 : 24-02-16 02:50
종료 시간 : 24-02-16 03:13
실행 시간 : 1791ms
메모리 : 21436KB
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1247_최적경로_D5 {
    static int TC, N;
    static int[] s = new int[2];
    static int[] e = new int[2];
    static int[][] nodes;
    static int ans;
    static int[][] result;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){

            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            ans = Integer.MAX_VALUE;
            result = new int[N][2];

            s[0] = Integer.parseInt(st.nextToken());
            s[1] = Integer.parseInt(st.nextToken());
            e[0] = Integer.parseInt(st.nextToken());
            e[1] = Integer.parseInt(st.nextToken());

            nodes = new int[N][2];
            for(int i = 0; i < N; i++){
                nodes[i][0] = Integer.parseInt(st.nextToken());
                nodes[i][1] = Integer.parseInt(st.nextToken());
            }

            per(0,0);
            sb.append(String.format("#%d %d%n", tc, ans));
        }

        System.out.print(sb);
    }

    private static void print() {
        System.out.println("==========");
        for (int i = 0; i < N; i++) {
            System.out.printf("(%d,%d) ", result[i][0], result[i][1]);
        }
    }

    private static void per(int cnt, int flag) {
        if(cnt == N){
            calcRoute();
            return;
        }

        for(int i = 0; i < N; i++){
            if((flag & 1 << i) != 0) continue;

            result[cnt] = nodes[i];
            per(cnt+1, flag | 1 << i);
        }

    }

    private static void calcRoute() {
        int route = 0;
        int[] cur = s;

        for(int i = 0; i < N; i++){
            route += Math.abs(cur[0] - result[i][0]) + Math.abs(cur[1] - result[i][1]);
            cur = result[i];
        }
        route += Math.abs(cur[0] - e[0]) + Math.abs(cur[1] - e[1]);

        ans = Math.min(ans, route);
    }
}