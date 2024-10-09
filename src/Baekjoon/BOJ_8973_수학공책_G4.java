package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_8973_수학공책_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            arr2[i] = sc.nextInt();
        }

        // Reverse the second array
        int[] arr2Reversed = new int[N];
        for (int i = 0; i < N; i++) {
            arr2Reversed[i] = arr2[N - 1 - i];
        }

        int maxBlur = Integer.MIN_VALUE;
        int bestB = 0;
        int bestE = 0;

        // Calculate the initial blur without any deletions
        int currentBlur = 0;
        for (int i = 0; i < N; i++) {
            currentBlur += arr1[i] * arr2Reversed[i];
        }

        // dp[B][E] stores the maximum blur possible by deleting B elements from the front and E from the back
        int[][] dp = new int[N][N];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        dp[0][0] = currentBlur;

        for (int B = 0; B < N; B++) {
            for (int E = 0; E < N - B; E++) {
                if (B > 0) {
                    dp[B][E] = Math.max(dp[B][E], dp[B - 1][E] - arr1[B - 1] * arr2Reversed[B - 1]);
                }
                if (E > 0) {
                    dp[B][E] = Math.max(dp[B][E], dp[B][E - 1] - arr1[N - E] * arr2Reversed[N - E]);
                }
                if (B > 0 && E > 0) {
                    dp[B][E] = Math.max(dp[B][E], dp[B - 1][E - 1] - arr1[B - 1] * arr2Reversed[B - 1] - arr1[N - E] * arr2Reversed[N - E]);
                }
                if (dp[B][E] > maxBlur) {
                    maxBlur = dp[B][E];
                    bestB = B;
                    bestE = E;
                }
            }
        }

        System.out.println(bestB + " " + bestE);
        System.out.println(maxBlur);
    }
}