package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-23 20:40
종료 시간 : 24-03-23 21:56
실행 시간 : 412ms / 실패
메 모 리 : 37904KB
*/

public class BOJ_9335_문자열폭발_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String line = br.readLine();
        String del = br.readLine();
        int lineLen = line.length();
        int delLen = del.length();

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < lineLen; i++) {

            s.add(line.charAt(i));

            if(s.size() >= delLen){
                boolean isMatch = true;

                // stack size - del.len
                for (int j = 0; j < delLen; j++) {
                    if(s.get(s.size() - delLen + j) != del.charAt(j)){
                        isMatch = false;
                        break;
                    }
                }

                if(isMatch){
                    for (int j = 0; j < delLen; j++) {
                        s.pop();
                    }
                }

            }
        }

        if(s.isEmpty()){
            System.out.println("FRULA");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : s){
            sb.append(c);
        }

        System.out.println(sb);
    }

}