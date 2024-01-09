package SWExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 파리퇴치 3
// 23-01-09 try 1
// 23-01-09 try 2
// 23-01-09 try 3
public class Solution12712 {
    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case < T + 1; test_case++){

            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] mat = new int[N][N];

            // Get N x N matrix
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    mat[i][j] = sc.nextInt();
                }
            }

            int maxSum = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){

                    int plusSum = 0;
                    int xSum = 0;

                    for(int iter = -(M - 1); iter <= M - 1; iter++){

                        if(i + iter >= 0 && i + iter < N) plusSum += mat[i + iter][j];
                        if(j + iter >= 0 && j + iter < N) plusSum += mat[i][j + iter];
                        if(i + iter >= 0 && i + iter < N && j + iter >= 0 && j + iter < N) xSum += mat[i + iter][j + iter];
                        if(i + iter >= 0 && i + iter < N && j - iter >= 0 && j - iter < N) xSum += mat[i + iter][j - iter];
                    }

                    plusSum -= mat[i][j];
                    xSum -= mat[i][j];

                    maxSum = Math.max(Math.max(plusSum, xSum), maxSum);
                }
            }

            System.out.println("#" + test_case + " " + maxSum);

        }
    }
}