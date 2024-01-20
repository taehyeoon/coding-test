package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
백준 1,2,3더하기 9095
시작 : 24-01-20 12:14
끝 : 24-01-20 12:30
실행시간 : 76ms


고려사항

 */
public class Solution9095 {

    static StringTokenizer st;
    static Map<Integer, Integer> memo = new HashMap<>() ;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        for(int t = 0; t < testCase; t++){
            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

            System.out.println(dp(n));
        }
    }

    private static int dp(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;

        if(!memo.containsKey(n))
            memo.put(n, dp(n-1) + dp(n-2) + dp(n-3));

        return memo.get(n);
    }

}