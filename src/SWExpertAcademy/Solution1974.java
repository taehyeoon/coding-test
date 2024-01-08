package SWExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution1974 {

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int test_case = 1; test_case < N + 1; test_case++){

            // input
            int[][] mat = new int[9][9];
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    mat[i][j] = sc.nextInt();
                }
            }

            int[] horizontal_list = new int[9];
            int[] vertical_list = new int[9];
            int[][] area_list = new int[3][3];

            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){

                    int val = 1 << (mat[i][j] - 1);
                    horizontal_list[i] += val;
                    vertical_list[j] += val;
                    area_list[i/3][j/3] += val;
                }
            }

            boolean answer = true;
            for(int val : horizontal_list){
                if(0b111111111 != val){
                    answer = false;
                    break;
                }
            }

            if(!answer) {
                System.out.println("#" + test_case + " " + 0);
                continue;
            }

            for(int val : vertical_list){
                if(0b111111111 != val){
                    answer = false;
                    break;
                }
            }

            if(!answer) {
                System.out.println("#" + test_case + " " + 0);
                continue;
            }

            for(int[] values : area_list){
                for(int val : values){
                    if(0b111111111 != val){
                        answer = false;
                        break;
                    }
                }
            }

            if(!answer) System.out.println("#" + test_case + " " + 0);
            else System.out.println("#" + test_case + " " + 1);

        }
    }
}