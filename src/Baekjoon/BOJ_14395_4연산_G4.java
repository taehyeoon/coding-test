package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-18 13:20
종료 시간 : 24-05-18 14:14
실행 시간 : 80ms
메 모 리 : 11692KB
*/

public class BOJ_14395_4연산_G4 {

    static class Node{
        int value;
        String cmd;

        public Node(int value, String cmd) {
            this.value = value;
            this.cmd = cmd;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int S, T;
    static Map<Integer, String> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        if(S == T) {
            System.out.println(0);
            return;
        }

        dp.put(S, "");

        int cnt = 0;
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(S, ""));

        while (!q.isEmpty()) {

            int qSize = q.size();
            cnt++;
            for (int iter = 0; iter < qSize; iter++) {

                Node cur = q.poll();
                String nextCmd;
                String origin;

                // *
                if(cur.value <= Math.sqrt(T)){
                    int mul = cur.value * cur.value;
                    nextCmd = cur.cmd+"*";
                    origin = dp.get(mul);
                    if (origin == null ||
                            nextCmd.length() < origin.length() ||
                            (nextCmd.length() == origin.length() && nextCmd.compareTo(origin) < 0)) {
                        dp.put(mul, nextCmd);
                        q.add(new Node(mul, nextCmd));
                    }
                }

                // +
                if(cur.value <= T/2){
                    int sum = cur.value + cur.value;
                    nextCmd = cur.cmd+"+";
                    origin = dp.get(sum);
                    if (origin == null ||
                            nextCmd.length() < origin.length() ||
                            (nextCmd.length() == origin.length() && nextCmd.compareTo(origin) < 0)) {
                        dp.put(sum, nextCmd);
                        q.add(new Node(sum, nextCmd));
                    }
                }

                // /
                if(cur.value != 0){
                    int div = 1;
                    nextCmd = cur.cmd+"/";
                    origin = dp.get(div);
                    if (origin == null ||
                            nextCmd.length() < origin.length() ||
                            (nextCmd.length() == origin.length() && nextCmd.compareTo(origin) < 0)) {
                        dp.put(div, nextCmd);
                        q.add(new Node(div, nextCmd));
                    }
                }
            }
        }

        System.out.println(dp.getOrDefault(T, "-1"));
    }
}