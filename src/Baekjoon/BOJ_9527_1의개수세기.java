package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_9527_1의개수세기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long N, M;
    static long[] dp = new long[55];

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        setDP();

        long ans = calOne(M) - calOne(N-1);
        System.out.println(ans);
    }

    private static long calOne(long x) {
        long cnt = x & 1;

        int size = (int) (Math.log(x) / Math.log(2));

        for (int i = size; i > 0; i--) {
            if((x & (1L << i)) != 0) {
                cnt += dp[i-1] + (x - (1L << i) + 1);
                x -= (1L << i);
            }
        }

        return cnt;

    }

    static void setDP() {
        dp[0] = 1;

        for (int i = 1; i < 55; i++) {
            dp[i] = (dp[i-1] << 1) + (1L << i);
        }
    }

}