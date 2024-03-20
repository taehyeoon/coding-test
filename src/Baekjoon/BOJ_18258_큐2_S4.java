package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-20 23:28
종료 시간 : 24-03-20 23:40
실행 시간 : 1124ms
메 모 리 : 324680KB
*/

public class BOJ_18258_큐2_S4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        StringJoiner stt = new StringJoiner("\n");

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            switch (cmd){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    q.offer(num);
                    break;
                case "pop":
                    if(q.isEmpty()) stt.add("-1");
                    else stt.add(q.poll().toString());
                    break;
                case "size":
                    stt.add(Integer.toString(q.size()));
                    break;
                case "empty":
                    stt.add(q.isEmpty()?"1":"0");
                    break;
                case "front":
                    if(q.isEmpty()) stt.add("-1");
                    else stt.add(q.getFirst().toString());
                    break;
                case "back":
                    if(q.isEmpty()) stt.add("-1");
                    else stt.add(q.getLast().toString());
            }

        }

        System.out.println(stt);
    }
}