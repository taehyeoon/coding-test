package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-04 02:30
종료 시간 : 24-05-04 02:50
실행 시간 : 124ms
메 모 리 : 15260KB
*/

public class BOJ_2138_전구와스위치_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        String b = br.readLine();
        boolean[] before = new boolean[N];
        for (int i = 0; i < N; i++) {
            if(b.charAt(i) == '1') before[i] = true;
        }

        String a = br.readLine();
        boolean[] after = new boolean[N];
        for (int i = 0; i < N; i++) {
            if(a.charAt(i) == '1') after[i] = true;
        }

        int push = 0;
        boolean[] temp = Arrays.copyOf(before, N);
        push++;
        temp[0] = !temp[0];
        temp[1] = !temp[1];

        for (int i = 1; i < N; i++) {
            if(temp[i-1] != after[i-1]){
                // push i
                push++;
                temp[i-1] = !temp[i-1];
                temp[i] = !temp[i];
                if(i+1 < N) temp[i+1] = !temp[i+1];
            }
        }

        if(temp[N-1] != after[N-1]) push = Integer.MAX_VALUE;

        //////////////
        int notPush = 0;

        temp = Arrays.copyOf(before, N);

        for (int i = 1; i < N; i++) {
            if(temp[i-1] != after[i-1]){
                // push i
                notPush++;
                temp[i-1] = !temp[i-1];
                temp[i] = !temp[i];
                if(i+1 < N) temp[i+1] = !temp[i+1];
            }
        }

        if(temp[N-1] != after[N-1]) notPush = Integer.MAX_VALUE;

        int ans = Math.min(push, notPush);
        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }
}