package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-03 14:15
종료 시간 : 24-02-05 21:15
실행 시간 : 96ms / 실패
메 모 리 : 11,548KB

고려사항
모듈러 성질 이용
(A*B) % M = ((A % M) * (B % M)) % M
A,B,C가 모두 int의 최대값을 가질 수 있기 때문에, 일반적인 거듭제곱 후 마지막 나머지 연산은
자료형 범위 초과로 틀리게됩니다.
자료형 범위를 초과하지 않게 하기위해서 모듈러 성질을 이용해야합니다.
또한 시간초과를 피하기 위해서는 재귀호출로 반복적인 계산을 최소화 해야합니다.
5의 제곱을 하는 경우 2의제곱 * 2의제곱 * 1의제곱으로 나누어 계산할수 있습니다.
*/

public class BOJ_1629_곱셈_S1 {
    static long A, B, C;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(B));
    }

    private static long pow(long expo){
        if(expo == 1) return A % C;

        long temp = pow(expo/2);
        if(expo % 2 == 0){
            return temp * temp % C;
        }else{
            return (temp * temp % C) * A % C;
        }
    }
}