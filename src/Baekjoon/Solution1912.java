package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 연속합 1912 S2
시작 시간 : 24-01-22 11:46
종료 시간 : 24-01-22 11:58
실행시간 : 204ms

고려사항
왼쪽부터 오른쪽으로 이동하며 탐색
왼쪽부터 k번째까지의 연속합 = max(k-1번째까지의 최대연속합, k번째 데이터)
*/

public class Solution1912 {

    static int N;
    static int[] data, maxList;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        StringTokenizer st = new StringTokenizer(br.readLine());
        data = new int[N];
        maxList = new int[N];

        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }


        maxList[0] = data[0];

        for (int i = 1; i < N; i++) {
            maxList[i] = Math.max(data[i], maxList[i-1] + data[i]);
        }

        int result = data[0];
        for(int val : maxList){
            if(val > result) result = val;
        }
        System.out.println(result);
    }
}