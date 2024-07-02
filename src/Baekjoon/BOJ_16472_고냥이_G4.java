package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_16472_고냥이_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] alphabet = new int[26];

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        if(str.length() == 1 || N == 1) {
            System.out.println(1);
            return;
        }else if(N == 26){
            System.out.println(str.length());
            return;
        }

        int l = 0, r = 1;
        alphabet[str.charAt(l)-'a']++;
        alphabet[str.charAt(r)-'a']++;

        int len = 2;
        int ans = 0;
        int vari = str.charAt(l) == str.charAt(r) ? 1 : 2;
        while (true){
            r++;
            len++;

            if(r == str.length()) break;
            if(alphabet[str.charAt(r)-'a'] != 0){
                alphabet[str.charAt(r)-'a']++;
            }else{
                if(vari < N){
                    vari++;
                }else{
                    do {
                        len--;
                    } while (--alphabet[str.charAt(l++) - 'a'] != 0);
                }
                alphabet[str.charAt(r)-'a']++;
            }
            ans = Math.max(ans, len);
        }
        System.out.println(ans);
    }
}