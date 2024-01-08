package SWExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution1961 {
    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int test_case = 1; test_case < N + 1; test_case++){

            int size = sc.nextInt();

            int[][] mat = new int[size][size];
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    mat[i][j] = sc.nextInt();
                }
            }

            int[][] result90 = new int[size][size];
            int[][] result180 = new int[size][size];
            int[][] result270 = new int[size][size];

//            turn 90 degrees
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    result90[i][j] = mat[size - j - 1][i];
                }
            }

//            turn 180 degrees
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    result180[i][j] = mat[size - i - 1][size - j - 1];
                }
            }

//            turn 270 degrees
            for(int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    result270[i][j] = mat[j][size - i - 1];
                }
            }

            System.out.println("#" + test_case + " ");

            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    System.out.print(result90[i][j]);
                }
                System.out.print(" ");

                for(int j = 0; j < size; j++){
                    System.out.print(result180[i][j]);
                }
                System.out.print(" ");

                for(int j = 0; j < size; j++){
                    System.out.print(result270[i][j]);
                }
                System.out.println();


            }
        }
    }
}