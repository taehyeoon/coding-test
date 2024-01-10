package SWExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 가랏! RC카!
// 23-01-11 try 1
public class Solution1940 {

    static int v, l, n;
    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case < T + 1; test_case++){

            v = 0;
            l = 0;
            n = sc.nextInt();

            for(int i = 0; i < n; i++){
                int command = sc.nextInt();
                if(command == 0) {
                    l += v;
                    continue;
                }

                int temp_v = sc.nextInt();

                if(command == 1) {
                    l += v + temp_v;
                    v += temp_v;
                }
                else if (command == 2) {
                    if(v - temp_v <= 0){
                        v = 0;
                    }else{
                        l += v - temp_v;
                        v -= temp_v;

                    }
                }

            }

            System.out.println("#" + test_case + " " + l);
        }
    }
}