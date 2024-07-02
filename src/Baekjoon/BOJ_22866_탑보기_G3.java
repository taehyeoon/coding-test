package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_22866_탑보기_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] input;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        input = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();
        List<int[]> answer = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            answer.add(new int[]{0,0});
        }

        stack.add(new int[]{1, input[1]});
        for (int i = 2; i <= N; i++) {
            int[] my = answer.get(i);
            while (!stack.isEmpty()) {
                int[] peek = stack.peek();
                if(peek[1] <= input[i]) stack.pop();
                else break;
            }

            if (!stack.isEmpty()) {
                int[] peek = stack.peek();
                my[1] = peek[0];
            }
            my[0] += stack.size();
            stack.add(new int[]{i, input[i]});
        }

        stack.clear();

        stack.add(new int[]{N, input[N]});
        for (int i = N-1; i >= 1; i--) {
            int[] my = answer.get(i);
            while (!stack.isEmpty()) {
                int[] peek = stack.peek();
                if(peek[1] <= input[i]) stack.pop();
                else break;
            }

            if (!stack.isEmpty()) {
                int[] peek = stack.peek();
                if(my[0] == 0) my[1] = peek[0];
                else{
                    int prevDis = Math.abs(i-my[1]);
                    int nowDis = Math.abs(i-peek[0]);
                    if(nowDis < prevDis) my[1] = peek[0];
                }
            }
            my[0] += stack.size();
            stack.add(new int[]{i, input[i]});
        }

        for (int i = 1; i <= N; i++) {
            int[] list = answer.get(i);
            if (list[0] == 0){
                System.out.println(0);
            }else{
                System.out.println(list[0] + " " + list[1]);
            }
        }
    }
}