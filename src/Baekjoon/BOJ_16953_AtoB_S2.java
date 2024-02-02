package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-03 03:45
종료 시간 : 24-02-03 03:55
실행 시간 : 80ms
메 모 리 : 11496KB

고려사항
자료형은 long을 사용해야 풀리는 문제였습니다.
dfs 재귀를 통해 B를 넘지 않는 한도 내에서
2를 곱하는 경우와, 오른쪽 끝에 1을 추가하는 경우를
탐색했습니다.
*/

public class BOJ_16953_AtoB_S2 {

    static long A, B;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        dfs(A, 0);

        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans+1);
    }

    private static void dfs(long val, int cnt) {

        if(val > B) return;
        if(val == B){
            ans = Math.min(ans, cnt);
            return;
        }

        dfs(val*10+1, cnt+1);
        dfs(val*2, cnt+1);
    }
}