package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-30 13:00
종료 시간 : 24-04-30 20:51
실행 시간 : 80ms / 실패
메 모 리 : 11552KB
*/

public class BOJ_3165_5_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    private static int count(List<Integer> s){

        int cnt = 0;
        for(int c : s){
            if(c == 5) cnt++;
        }
        return cnt;
    }

    private static boolean roundUp(List<Integer> number, int ptr) {

        number.set(ptr, 0);

        ptr--;
        while(ptr >= 0){

            int left = number.get(ptr);
            if(left + 1 > 9){
                number.set(ptr, 0);
                ptr--;
            }else{
                number.set(ptr, left+1);
                return false;
            }
        }
        number.add(0, 1);
        return true;
    }
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int K = Integer.parseInt(st.nextToken());

        if(N.length() <= K){
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < K; i++) {
                res.append('5');
            }
            System.out.println(res);
            return;
        }

        N =  Long.toString(Long.parseLong(N)+1);
        List<Integer> number = new ArrayList<>();
        for(char c : N.toCharArray()){
            number.add(c - '0');
        }

        // 1의 자리부터 시작
        int ptr = N.length()-1;
        while (count(number) != K){
            int c = number.get(ptr);

            if(c < 5){
                number.set(ptr, 5);
                ptr--;
            }else if(c > 5){
                // 자리수 증가를 추적해서 ptr를 1증가시켜야 제자리임
                boolean isRoundUp = roundUp(number, ptr);
                if(isRoundUp){
                    ptr++;  // 이게 제자리에 있는거임
                }
            }else{
                ptr--;
            }
        }

        StringBuilder res = new StringBuilder();
        for(int i : number){
            res.append(i);
        }
        System.out.println(res);
    }
}