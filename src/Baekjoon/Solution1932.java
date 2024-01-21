package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 정수 삼각형 1932 S1
시작 시간 : 24-01-21 16:00
중지 :
종료 시간 : 24-01-21 16:17
실행시간 : 232ms

고려사항
꼭대기부터 탐색 시작
바닥부터 현재 노드까지의 최대합 = max(왼쪽 아래 노드의 최대합, 오른쪽 아래 노드의 최대합) + 현재 노드 값
재귀 호출을 통해 각 노드까지의 최대합 저장
 */

public class Solution1932 {

    static int N;
    static int[][] data;
    static Integer[][] memo;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        data = new int[N][N];
        memo = new Integer[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dp(0,0));
    }

    private static int dp(int idxI, int idxJ) {

        if(idxI == N-1) return data[idxI][idxJ];

        if(memo[idxI][idxJ] == null)
            memo[idxI][idxJ] = Math.max(dp(idxI+1, idxJ), dp(idxI+1, idxJ+1)) + data[idxI][idxJ];

        return memo[idxI][idxJ];
    }
}