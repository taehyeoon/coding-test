package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-09 15:40
종료 시간 : 24-03-09
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_11444_피보나치수6_G2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BigInteger N;

    static Map<String, String> map = new HashMap<>();
    public static void main(String[] args) throws IOException {

        N = new BigInteger(br.readLine());

        if(N.compareTo(new BigInteger("1")) == 0){
            System.out.println(0);
            return;
        }else if(N.compareTo(new BigInteger("2")) == 0){
            System.out.println(1);
            return;
        }

        String pprev = "0";
        String prev = "1";

        N = N.subtract(BigInteger.ONE);
        N = N.subtract(BigInteger.ONE);
        String ans = "";
        while(N.compareTo(new BigInteger("0")) != 0){
            String before = pprev + " " + prev;
            if(map.containsKey(before)){
                pprev = prev;
                prev = map.get(before);
            }else{
                String[] s1s2 = before.split(" ");

                long res = Long.parseLong(s1s2[0]);
                long adder = Long.parseLong(s1s2[1]);

//                System.out.println("res = " + res);
//                System.out.println("adder = " + adder);
                pprev = prev;
                String cur = Long.toString(((res + adder)% 1_000_000_007));
                prev = cur;
//                System.out.println("cur = " + cur);
                map.put(before, cur);
            }
            ans = map.get(before);
//            System.out.println(map.get(before));
            N = N.subtract(BigInteger.ONE);
        }
        System.out.println(ans);
    }
}