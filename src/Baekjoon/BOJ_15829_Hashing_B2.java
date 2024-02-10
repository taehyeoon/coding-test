package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
시작 시간 : 24-02-10 13:50
종료 시간 : 24-02-10 14:07
실행시간 : 80ms
메 모 리 : 15829KB

고려사항
정수 합동론을 이용하여 나머지 연산을 하였습니다
AB % MOD = (A %MOD * B %MOD) %MOD
R을 거듭제곱 할때마다 미리 MOD로 나누어 수가 overflow되지 않도록 하였습니다.
*/

public class BOJ_15829_Hashing_B2 {

    static final int MOD = 1_234_567_891;
    static final int R = 31;
    static int N;
    static char[] arr;

    private static void input() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();
    }

    private static long solve() {
        long ans = 0;
        long mul = 1;
        for(int i = 0; i < N; i++){
            ans += ((arr[i] - 'a' + 1) * mul) % MOD;
            mul = (mul * R) % MOD;
        }
        return ans % MOD;
    }

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(solve());
    }
}
