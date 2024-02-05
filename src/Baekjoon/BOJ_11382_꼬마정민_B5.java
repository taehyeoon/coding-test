package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-04 21:40
종료 시간 : 24-02-04 21:42
실행 시간 : 76ms
메 모 리 : 11732KB

고려사항
큰 수를 계산할 때, BigInteger를 사용하는 것이 포인트였습니다.
*/

public class BOJ_11382_꼬마정민_B5 {

    static BigInteger A, B, C;
    static int[][] remains = new int[11][5];
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = BigInteger.valueOf(Long.parseLong(st.nextToken()));
        B = BigInteger.valueOf(Long.parseLong(st.nextToken()));
        C = BigInteger.valueOf(Long.parseLong(st.nextToken()));

        System.out.println(A.add(B).add(C));


    }
}