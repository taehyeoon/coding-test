package com.ssafy.coding;

import java.io.*;
import java.math.*;
import java.util.*;

/*
시작 시간 : 24-04-02 11:15
종료 시간 : 24-04-02 11:45
실행 시간 : 96ms / 수업
메 모 리 : 17676KB
*/

public class BOJ_2749_피보나치수3_G2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    
    public static void main(String[] args) throws IOException {

    	int[] dp = new int[150_0000];
    	dp[0] = 0;
    	dp[1] = 1;
    	dp[2] = 1;
    	
    	for(int i = 3; i < 150_0000; i++) {
    		dp[i] = (dp[i-1] + dp[i-2]) % 1_000_000;
    	}
    	
    	BigInteger n = new BigInteger(br.readLine());
    	BigInteger divider = new BigInteger("1500000");
    	BigInteger res = n.mod(divider);
    	
    	int resToInt = res.intValue();
    	
    	System.out.println(dp[resToInt]);
        
    }
}