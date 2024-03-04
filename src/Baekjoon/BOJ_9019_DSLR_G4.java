package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
시작 시간 : 24-03-04 23:00
종료 시간 : 24-03-05 00:45
실행 시간 : 10252ms
메 모 리 : 331632KB
*/

public class BOJ_9019_DSLR_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static int A, B;

    static Integer[][] memo = new Integer[10_000][4];

    private static String solve(){

        Queue<Integer> q = new ArrayDeque<>();
        String[] result = new String[10_000];
        boolean[] visited = new boolean[10_000];
        result[A] = "";
        visited[A] = true;
        q.offer(A);

        while (!q.isEmpty()) {

            for (int iter = 0, size = q.size(); iter < size; iter++) {
                int cur = q.poll();

                if(cur == B) return result[cur];

                int next = -1;

                // D
                if(memo[cur][0] == null){
                    memo[cur][0] = getDouble(cur);
                }
                next = memo[cur][0];
                if(!visited[next]){
                    visited[next] = true;
                    result[next] = result[cur] + "D";
                    q.offer(next);
                }

                // S
                if(memo[cur][1] == null){
                    memo[cur][1] = getMinus(cur);
                }
                next = memo[cur][1];
                if(!visited[next]){
                    visited[next] = true;
                    result[next] = result[cur] + "S";
                    q.offer(next);
                }

                // L
                if(memo[cur][2] == null){
                    memo[cur][2] = getLeft(cur);
                }
                next = memo[cur][2];
                if(!visited[next]){
                    visited[next] = true;
                    result[next] = result[cur] + "L";
                    q.offer(next);
                }

                // R
                if(memo[cur][3] == null){
                    memo[cur][3] = getRight(cur);
                }
                next = memo[cur][3];
                if(!visited[next]){
                    visited[next] = true;
                    result[next] = result[cur] + "R";
                    q.offer(next);
                }

            }
        }
        return "error";

    }

    private static int getLeft(int x) {
        String cur = String.format("%04d", x);
        String str = cur.substring(1, 4);
        str += cur.charAt(0);
        return Integer.parseInt(str);
    }

    private static int getRight(int x) {
        String cur = String.format("%04d", x);
        String str = "";
        str += cur.charAt(3);
        str += cur.substring(0, 3);
        return Integer.parseInt(str);
    }

    private static int getDouble(int x){
        return (2*x) % 10_000;
    }

    private static int getMinus(int x) {
        if(x == 0) return 9999;
        return x-1;
    }
    public static void main(String[] args) throws IOException {

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            sb.append(solve()).append("\n");
        }

        System.out.println(sb);
    }
}