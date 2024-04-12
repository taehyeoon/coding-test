package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-13 04:55
종료 시간 : 24-04-13 05:07
실행 시간 : 1320ms
메 모 리 : 250348KB
*/

public class BOJ_28279_덱2_S4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringJoiner sj = new StringJoiner("\n");
    static StringTokenizer st;
    static ArrayDeque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            int x;
            switch (cmd) {
                case 1:
                    x = Integer.parseInt(st.nextToken());
                    dq.addFirst(x);
                    break;
                case 2:
                    x = Integer.parseInt(st.nextToken());
                    dq.addLast(x);
                    break;
                case 3:
                    if(dq.isEmpty()) sj.add("-1");
                    else sj.add(dq.pollFirst().toString());
                    break;
                case 4:
                    if(dq.isEmpty()) sj.add("-1");
                    else sj.add(dq.pollLast().toString());
                    break;
                case 5:
                    sj.add(dq.size()+"");
                    break;
                case 6:
                    sj.add(dq.isEmpty() ? "1" : "0");
                    break;
                case 7:
                    if(dq.isEmpty()) sj.add("-1");
                    else sj.add(dq.peekFirst().toString());
                    break;
                case 8:
                    if(dq.isEmpty()) sj.add("-1");
                    else sj.add(dq.peekLast().toString());
                    break;
            }
        }
        bw.write(sj.toString());
        bw.close();

    }
}