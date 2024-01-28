package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 구간합구하기4 11659 S3
시작 시간 : 24-01-28 15:00
종료 시간 : 24-01-28 16:00
실행시간 : 2364ms / 실패

고려사항
정답 참조
누적합의 성질을 이용하는 문제였습니다.
구간 a~b의 합 = 0~b 누적합 - 0~a-1 누적합
으로 표현할 수 있습니다.
N개의 데이터를 받을 때, 0~k까지의 모든 누적합을 accSum 배열에 저장하고 ( 1 <= k <= N)
구간마다 (0~end)sum - (0~start-1)sum을 통해서 구간 합을 구할 수 있습니다.
 */

public class Solution11659 {

    static int N, M;
    static int[] accSum;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        accSum = new int[N+1];
        for (int i = 1; i <= N; i++) {
            accSum[i] = accSum[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            System.out.println(accSum[e] - accSum[s-1]);
        }

    }
}