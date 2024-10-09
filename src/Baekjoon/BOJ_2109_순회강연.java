package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_2109_순회강연 {

    static class Lect implements Comparable<Lect>{
        int p, d;
        public Lect(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Lect o) {
            // d가 큰 것 부터
            if(this.d != o.d) return Integer.compare(o.d,this.d);
            // p도 큰 것 부터
            else return Integer.compare(o.p, this.p);
        }

        @Override
        public String toString() {
            return "Lect{" +
                "p=" + p +
                ", d=" + d +
                '}';
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Lect[] lects;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        if(n == 0){
            System.out.println(0);
            return;
        }
        lects = new Lect[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            lects[i] = new Lect(p, d);
        }

        Arrays.sort(lects);

        long sum = 0;

        PriorityQueue<Integer> restLect = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n-1; i++) {
            restLect.add(lects[i].p);

            if(lects[i].d == lects[i+1].d) continue;

            int diff = lects[i].d - lects[i+1].d;
            while(!restLect.isEmpty() && diff > 0){
                sum += restLect.poll();
                diff--;
            }
        }

        restLect.add(lects[n-1].p);
        int diff = lects[n-1].d;
        while(!restLect.isEmpty() && diff > 0){
            sum += restLect.poll();
            diff--;
        }
        System.out.println(sum);
    }
}