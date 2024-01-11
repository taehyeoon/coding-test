package SWExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// [S/W 문제해결 기본] 1일차 - View D3
// 23-01-11 try 1
public class Solution1206 {

    static int[] heights;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = 10;

        for(int test_case = 1; test_case < T + 1; test_case++){

            int build_count = sc.nextInt();
            int result = 0;

            heights = new int[build_count];

            for(int iter = 0; iter < build_count; iter++){
                heights[iter] = sc.nextInt();
            }

            for(int i = 2; i < build_count - 2; i++){
                int left = Math.max(heights[i-2], heights[i-1]);
                int right = Math.max(heights[i+1], heights[i+2]);
                if(heights[i] > Math.max(left, right)){
                    result += heights[i] - Math.max(left, right);
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}