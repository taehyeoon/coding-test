package SWExpertAcademy;

/*
시작 시간 : 24-02-01 23:50
종료 시간 : 24-02-02 00:05
실행 시간 : 136ms
메모리 : 20232KB

고려사항
완전 탐색으로 해결
*/

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_2001_파리퇴치_D2 {

    static int TC, N, M, maxSum;
    static int[][] input;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++) {
            maxSum = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            input = new int[N][N];

            // 입력
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    input[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 파리 개수 패치별 계산
            for (int i = 0; i < N - M + 1; i++) {
                for (int j = 0; j < N - M + 1; j++) {
                    int sum = calcPatch(i, j);
                    maxSum = Math.max(maxSum, sum);
                }
            }

            System.out.printf("#%d %d%n", tc, maxSum);
        }
    }

    private static int calcPatch(int idxI, int idxJ) {
        int sum = 0;

        for (int i = idxI; i < idxI+M; i++) {
            for (int j = idxJ; j < idxJ+M; j++) {
                sum += input[i][j];
            }
        }
        return sum;
    }
}