package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
백준 피보나치함수 1003 S3
시작 시간 : 24-01-20 15:00
종료 시간 : 24-01-20 15:12
실행시간 : 80ms

고려사항
 */

public class Solution1003 {

    // n번 째 피보나치 수에는 int[0]개의 0과 int[1]개의 1이 존재
    static Map<Integer, int[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            int[] result = fibo(n);
            System.out.println(result[0] + " " + result[1]);
        }
    }

    static int[] fibo(int n){
        if(n == 0) return new int[]{1,0};
        if(n == 1) return new int[]{0,1};

        if(!map.containsKey(n)) {

            int[] n_1 = fibo(n-1);
            int[] n_2 = fibo(n-2);

            map.put(n, new int[]{n_1[0] + n_2[0], n_1[1] + n_2[1]});
        }

        return map.get(n);
    }
}