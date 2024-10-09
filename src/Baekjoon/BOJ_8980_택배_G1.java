package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_8980_택배_G1 {

    static class Box implements Comparable<Box>{
        int s, e, quantity;

        public Box(int s, int e, int quantity) {
            this.s = s;
            this.e = e;
            this.quantity = quantity;
        }

        @Override
        public int compareTo(Box o) {

            if(this.e == o.e){
                return this.s - o.s;
            }
            return this.e - o.e;
        }

        @Override
        public String toString() {
            return "Box{" +
                "s=" + s +
                ", e=" + e +
                ", quantity=" + quantity +
                "}\n";
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, C, M;
    static Box[] boxes;
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        boxes = new Box[M+1];


        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            boxes[i] = new Box(s, e, q);
        }

        Arrays.sort(boxes,1, M+1);

        int[] weights = new int[N+1];
        for (int i = 1; i <= N; i++) {
            weights[i] = C;
        }

        int ans = 0;
        for (int i = 1; i <= M; i++) {
            Box b = boxes[i];

            int maxBoxNum = Integer.MAX_VALUE;

            for (int j = b.s; j < b.e; j++) {
                maxBoxNum = Math.min(maxBoxNum, weights[j]);
            }

            if(maxBoxNum >= b.quantity) {
                for (int j = b.s; j < b.e; j++) {
                    weights[j] -= b.quantity;
                }
                ans += b.quantity;
            }else{
                for (int j = b.s; j < b.e; j++) {
                    weights[j] -= maxBoxNum;
                }
                ans += maxBoxNum;
            }
        }

        System.out.println(ans);

    }
}