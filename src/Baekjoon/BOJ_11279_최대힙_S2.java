package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-03 13:30
종료 시간 : 24-03-03 13:45
실행 시간 : 304ms
메 모 리 : 25504KB
*/

public class BOJ_11279_최대힙_S2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringJoiner sj = new StringJoiner("\n");

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N ; i++){
            int cmd = Integer.parseInt(br.readLine());
            if (cmd == 0) {
                if(pq.isEmpty()) {
                    sj.add("0");
                }else{
                    sj.add(pq.poll().toString());
                }
            }else{
                pq.offer(cmd);
            }
        }
        System.out.println(sj);
    }
}