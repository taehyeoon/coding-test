package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-07-07
종료 시간 : 24-07-07
실행 시간 : ms / 실패
메 모 리 : KB
*/

public class BOJ_12850_본대산책2_G1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long MOD = 1_000_000_007;

    static long[][] square(long[][] arr1, long[][] arr2){
        long[][] new_arr = new long[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    new_arr[i][j] = (new_arr[i][j] + (arr1[i][k] * arr2[k][j]) % MOD) % MOD;
                }
            }
        }
        return new_arr;
    }

    private static long[][] divide(long[][] arr, long n) {

        if(n == 1) return arr;

        if(n%2==0){
            long[][] arr1 = divide(arr, n/2);
            return square(arr1, arr1);
        }else{
            return square(divide(arr, n-1), arr);
        }
    }

    public static void main(String[] args) throws IOException {

        long n = Long.parseLong(br.readLine());
        long[][] arr = new long[8][8];

        arr[0][1] = arr[0][7] = arr[1][0] = arr[1][7] = arr[1][2] = arr[2][1] = 1;
        arr[2][7] = arr[2][6] = arr[2][3] = arr[3][2] = arr[3][6] = arr[3][4] = 1;
        arr[4][3] = arr[4][5] = arr[5][4] = arr[5][6] = arr[6][2] = arr[6][3] = 1;
        arr[6][5] = arr[6][7] = arr[7][0] = arr[7][1] = arr[7][2] = arr[7][6] = 1;

        arr = divide(arr, n);

        System.out.println(arr[0][0]);

    }
}