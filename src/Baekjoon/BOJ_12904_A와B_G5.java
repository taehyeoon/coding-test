package Baekjoon;

import java.io.*;

/*
시작 시간 : 24-03-16 14:50
종료 시간 : 24-03-16 16:00
실행 시간 : 96ms
메 모 리 : 14828KB
*/

public class BOJ_12904_A와B_G5 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String s = br.readLine();
        String t = br.readLine();

        while(s.length() != t.length()){

            if(t.charAt(t.length()-1) == 'A'){
                // 마지막 A 삭제
                t = t.substring(0, t.length()-1);
            }else{
                // 마지막 B 삭제
                t = t.substring(0, t.length()-1);
                // 거꾸로 변환
                t = new StringBuffer(t).reverse().toString();
            }
        }

        System.out.println(s.equals(t) ? 1 : 0);
    }
}