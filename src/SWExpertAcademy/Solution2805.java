package SWExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 농작물 수확하기 D3
// 23-01-14 try 1
//
public class Solution2805 {

    static int[][] mat;
    static int result;
    static int n;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case < T + 1; test_case++){

            result = 0;
            n = sc.nextInt();
            mat = new int[n][n];
            int dis = n / 2;
            int center = n / 2;

            for(int i = 0; i < n; i++){
                String row = sc.next();
                for(int j = 0; j < n; j++){
                    mat[i][j] = row.charAt(j) - '0';
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(Math.abs(i - center) + Math.abs(j - center) <= dis) result += mat[i][j];
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }


}