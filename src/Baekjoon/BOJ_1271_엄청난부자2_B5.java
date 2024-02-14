package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-14 20:40
종료 시간 : 24-02-14 20:45
실행시간 : 80ms
메 모 리 : KB

고려사항

*/

public class BOJ_1271_엄청난부자2_B5 {

    static BigInteger M, N;

    public static void main(String[] args) throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = new BigInteger(st.nextToken());
        N = new BigInteger(st.nextToken());

        System.out.println(M.divide(N) + " " + M.mod(N));
    }
}
