package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

/*
시작 시간 : 24-02-04 01:20
종료 시간 : 24-02-04 02:20
실행 시간 : 148ms
메 모 리 : 11744KB

고려사항
1. K==0일 때, K!=0일 때를 고려
2. 큰 수 계산에 BigInteger를 사용
3. K값을 가지고, 조합을 2개로 분리하여 계산
*/

public class BOJ_10164_격자상의경로_S1 {

    static int N,M,K;
    static Map<String, BigInteger> map = new HashMap<>();
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K == 0){
            System.out.println(combi(N+M-2, N-1));
            return;
        }

        int n = (K-1) / M;
        int m = (K-1) % M;

        BigInteger a = combi(n+m,m);
        BigInteger b = combi(M-1-m + N-n-1, M-1-m);
        System.out.println(a.multiply(b));
    }

    private static BigInteger combi(int m, int n){

        if(n==0|n==m) return BigInteger.ONE;

        String str = m+","+n;
        if(!map.containsKey(str)){
            BigInteger val = combi(m-1, n-1).add(combi(m-1, n));
            map.put(str, val);
        }

        return map.get(str);
    }
}