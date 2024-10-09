package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1111_IQTest_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if(N == 1){
            System.out.println("A");
        }else if(N == 2){
            if(nums[0] == nums[1]){
                System.out.println(nums[0]);
            }else{
                System.out.println("A");
            }
        }else{

            if(nums[0] == nums[1]){
                int cre = nums[0];
                for (int i = 0; i < N; i++) {
                    if(cre != nums[i]){
                        System.out.println("B");
                        return;
                    }
                }
                System.out.println(cre);
                return;
            }

            int[] eq1 = new int[3]; // a계수, b계수, c
            int[] eq2 = new int[3];


            eq1[0] = nums[0];
            eq1[1] = 1;
            eq1[2] = nums[1];

            eq2[0] = nums[1];
            eq2[1] = 1;
            eq2[2] = nums[2];


            if(Math.abs(eq2[2] - eq1[2]) % Math.abs(eq2[0] - eq1[0]) == 0){

                int a = (eq2[2] - eq1[2]) / (eq2[0] - eq1[0]);
                int b = eq1[2] - (eq1[0]*a);

                for (int idx = 0; idx <= N-2; idx++) {
                    if(nums[idx] * a + b != nums[idx+1]){
                        System.out.println("B");
                        return;
                    }
                }
                System.out.println(nums[N-1] * a + b);
            }else{
                System.out.println("B");
            }

        }

    }
}