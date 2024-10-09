package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_25381_ABBC_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        int ans = 0;
        ArrayDeque<Integer> aq = new ArrayDeque<>();
        ArrayDeque<Integer> bq = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)){
                case 'A':
                    aq.offerLast(i);
                    break;

                case 'B':
                    bq.offerLast(i);
                    break;

                case 'C':
                    if(!bq.isEmpty() && bq.getFirst() < i){
                        ans++;
                        bq.pollFirst();
                    }
                    break;
            }
        }

        while (!aq.isEmpty() && !bq.isEmpty()){
            if(aq.getFirst() < bq.getFirst()){
                ans++;
                aq.pollFirst();
                bq.pollFirst();
            }else{
                bq.pollFirst();
            }
        }
        System.out.println(ans);
    }
}