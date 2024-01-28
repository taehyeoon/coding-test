package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 최소힙 1927 S2
시작 시간 : 24-01-28 17:00
종료 시간 : 24-01-28 17:05
실행시간 : 1572ms

고려사항
우선순위 큐를 이용하여 배열의 원소 추가 및 삭제를 진행하였습니다.
우선순위 큐의 capacity 증가 방식은 원소가 64개보다 클 경우 현재 크기의 절반씩 크기를 키우기 때문에
불필요한 배열을 복사를 막기위해
초기 크기를 N/2로 설정하였습니다.
 */

public class Solution1927 {

    static int N;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>(N/2);
        for (int i = 0; i < N; i++) {
            int cmd = Integer.parseInt(br.readLine());

            if(cmd == 0){
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }else{
                pq.add(cmd);
            }
        }

    }
}