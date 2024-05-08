package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-08 16:00
종료 시간 : 24-05-08 20:35
실행 시간 : 628ms
메 모 리 : 70040KB
*/

public class BOJ_23090_난민_G1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Long> leftTree = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> rightTree = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());

        long lSum = y, rSum = 0;
        long widthSum = Math.abs(x);

        leftTree.offer(y);
        sb.append(y).append(" ").append(Math.abs(x)).append("\n");
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            x = Long.parseLong(st.nextToken());
            y = Long.parseLong(st.nextToken());

            widthSum += Math.abs(x);

            if(leftTree.size() > rightTree.size()){
                long left = leftTree.peek();

                if(y >= left){
                    rSum += y;
                    rightTree.offer(y);
                }else{
                    lSum -= left; leftTree.poll();
                    rSum += left; rightTree.offer(left);

                    leftTree.offer(y); lSum += y;
                }
            }
            else{
                if(y <= rightTree.peek()){
                    leftTree.offer(y);

                    lSum += y;
                }else{

                    long right = rightTree.poll();

                    rSum -= right;
                    leftTree.offer(right); lSum += right;

                    rightTree.offer(y);
                    rSum += y;
                }
            }
            long base = leftTree.peek();
            long value = (leftTree.size()*base - lSum) + (rSum - rightTree.size()*base) + widthSum;
            sb.append(base).append(" ").append(value).append("\n");
        }

        System.out.println(sb);

    }
}