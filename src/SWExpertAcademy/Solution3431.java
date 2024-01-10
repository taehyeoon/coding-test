package SWExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 준환이의 운동관리 D3
// 23-01-11 try 1
public class Solution3431 {

    static int l, u, x, result;
    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case < T + 1; test_case++){

            l = sc.nextInt();
            u = sc.nextInt();
            x = sc.nextInt();

            if(x < l) result = l - x;
            else if(x <= u) result = 0;
            else result = -1;

            System.out.println("#" + test_case + " " + result);
        }
    }
}