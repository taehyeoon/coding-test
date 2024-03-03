package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringJoiner;

/*
시작 시간 : 24-03-03 13:48
종료 시간 : 24-03-03 13:51
실행 시간 : 280ms
메 모 리 : 24336KB
*/

public class BOJ_11286_절대값힙_S1 {

    static class Number implements Comparable<Number> {
        int x;

        public Number(int x) {
            this.x = x;
        }

        @Override
        public int compareTo(Number o) {
            if(Math.abs(this.x) == Math.abs(o.x)) return this.x - o.x;
            else return  Math.abs(this.x) - Math.abs(o.x);
        }

        @Override
        public String toString() {
            return String.valueOf(this.x);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringJoiner sj = new StringJoiner("\n");
    
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Number> pq = new PriorityQueue<>();

        for(int i = 0; i < N ; i++){
            int cmd = Integer.parseInt(br.readLine());
            if (cmd == 0) {
                if(pq.isEmpty()) {
                    sj.add("0");
                }else{
                    sj.add(pq.poll().toString());
                }
            }else{
                pq.offer(new Number(cmd));
            }
        }
        System.out.println(sj);
    }
}