package SWExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

// [S/W 문제해결 기본] 1일차 - Flatten D3
// 23-01-12 try 1
public class Solution1208 {

    static int[] boxes;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = 10;

        for(int test_case = 1; test_case < T + 1; test_case++){

            int limit = sc.nextInt();
            boxes = new int[100];

            for(int i = 0; i < 100; i++){
                boxes[i] = sc.nextInt();
            }

            Arrays.sort(boxes);

            int l = 0, r = 99;

            while (limit-- > 0){

                if(r == 99){
                    while(boxes[r] == boxes[r - 1]) r--;
                }

                if (l == 0) {
                    while(boxes[l] == boxes[l + 1]) l++;
                }

                boxes[r]--; r = Math.min(99, ++r);
                boxes[l]++; l = Math.max(0, --l);
            }

            System.out.println("#" + test_case + " " + (boxes[99] - boxes[0]));
        }
    }
}