package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-16 17:35
종료 시간 : 24-03-16 18:19
실행 시간 : 812ms
메 모 리 : 327280KB
*/

public class BOJ_18115_카드놓기_S3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] order;
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        order = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {

        input();

        ArrayDeque<Integer> res = new ArrayDeque<>();

        res.add(1);
        if(N >= 2){
            if(order[N-2] == 1) res.addFirst(2);
            else res.add(2);
        }

        for (int i = N-3, card = 3; i >= 0; i--, card++) {
            if(order[i] == 1){
                res.addFirst(card);
            }else if(order[i] == 2){
                int first = res.pollFirst();
                res.addFirst(card);
                res.addFirst(first);
            }else{
                res.add(card);
            }
        }

        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < N; i++) {
            sb.append(res.poll() + " ");
        }
        bw.write(sb.toString());
        bw.close();
    }
}