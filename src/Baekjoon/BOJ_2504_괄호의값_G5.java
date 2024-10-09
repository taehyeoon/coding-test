package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
시작 시간 : 24-03-10 22:30
종료 시간 : 24-03-10
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_2504_괄호의값_G5 {

    static int N;
    static char[] data;
    static int idx;
    static boolean isValid;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        data = br.readLine().toCharArray();
        N = data.length;
    }

//    private static int dfs(){
//        idx++;
//        if (data[idx] == '('){
//            int sum = 2 * dfs();
//            if(data[idx] == ')') return sum;
//            else{
//                isValid = false;
//                return -1;
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {
        input();

        idx = -1;
        isValid = true;
        Stack<Character> s = new Stack<>();
        Stack<Integer> mul = new Stack<>();
        for (int i = 0; i < N; i++) {
            if(s.empty()){
                if(data[i] == '('){
                    s.add(')');
                    mul.add(2);
                }else if(data[i] == '['){
                    s.add(']');
                    mul.add(3);
                }
            }else{

//                if(data[i] == s.peek())





            }


        }

//        System.out.println(dfs());
    }
}