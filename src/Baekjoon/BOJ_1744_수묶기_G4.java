package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-16 14:05
종료 시간 : 24-03-16 14:27
실행 시간 : 84ms
메 모 리 : 11512KB
*/

public class BOJ_1744_수묶기_G4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int zeroCnt;
    static PriorityQueue<Integer> negative, positive;

    private static void input() throws IOException{

        negative = new PriorityQueue<>();
        positive = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num < 0) negative.offer(num);
            else if(num > 0) positive.offer(num);
            else zeroCnt++;
        }
    }

    public static void main(String[] args) throws IOException {

        input();

        int sum = 0;

        while (!positive.isEmpty()){
            int cur = positive.poll();
            if(positive.peek() == null){
                sum += cur;
                break;
            }
            if(cur == 1 || positive.peek() == 1) sum += cur;
            else sum += cur * positive.poll();
        }

        while (!negative.isEmpty()) {
            int cur = negative.poll();
            if(negative.peek() == null){

                if(zeroCnt > 0) break;
                else sum += cur;

                break;
            }
            sum += cur * negative.poll();
        }

        System.out.println(sum);
    }
}