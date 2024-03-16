package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-15 20:00
종료 시간 : 24-03-15 20:45
실행 시간 : 224ms
메 모 리 : 13352KB
*/

public class BOJ_6064_카잉달력_S1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    private static int solve(int n, int m, int x, int y) {

        int gcd = getGCD(n, m);
        int lcm = n * m / gcd;

        if(n <= m){
            for (int i = x, j = x; i <= lcm; i += n, j+= n) {
                j %= m;
                if(j == 0) j = m;
                if(j == y) return i;
            }
        }else{
            for (int i = y, j = y; j <= lcm; i += m, j+= m) {
                i %= n;
                if(i == 0) i = n;
                if(i == x) return j;
            }

        }

        return -1;
    }

    private static int getGCD(int a, int b) {

        if(b == 0) return a;

        if(a<b){
            int temp = a;
            a = b;
            b = temp;
        }

        return getGCD(b, a%b);
    }


    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(solve(n,m,x,y)).append("\n");

        }
        System.out.println(sb);
    }
}