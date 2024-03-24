package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-22 23:40
종료 시간 : 24-03-24 10:00
실행 시간 : 1104ms
메 모 리 : 168028KB
*/

public class BOJ_5397_키로거_S2 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int TC = Integer.parseInt(br.readLine());
        StringBuilder ansBuilder = new StringBuilder();

        for (int tc = 0; tc < TC; tc++) {
            String cmd = br.readLine();
            Stack<Character> f = new Stack<>();
            Stack<Character> b = new Stack<>();

            for (int i = 0; i < cmd.length(); i++) {
                char c = cmd.charAt(i);

                switch (c){
                    case '<':
                        if(!f.isEmpty()){
                            char cursor = f.pop();
                            b.add(cursor);
                        }
                        break;
                    case'>':
                        if (!b.isEmpty()) {
                            char cursor = b.pop();
                            f.add(cursor);
                        }
                        break;
                    case '-':
                        if (!f.isEmpty()) {
                            f.pop();
                        }
                        break;
                    default:
                        f.add(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            for(char c : f) sb.append(c);
            while (!b.isEmpty()) sb.append(b.pop());

            ansBuilder.append(sb).append("\n");
        }
        System.out.println(ansBuilder);
    }

}