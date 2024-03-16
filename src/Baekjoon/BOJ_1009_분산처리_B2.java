package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-02-05 20:10
종료 시간 : 24-02-05
실행 시간 : 956ms
메 모 리 : 13,483KB

고려사항
숫자의 1의자리수는 자기자신을 곱했을 때
일정한 규칙성을 가진다는 것을 이용하였습니다.
*/

public class BOJ_1009_분산처리_B2 {

    static int T, a, b;
    static int[][] remains = new int[11][5];
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            a %= 10;
            int cur = a;
            for(int i = 0; i < b-1; i++){
                cur = a*cur%10;
            }
            if(cur == 0) sb.append(10);
            else sb.append(cur);
            sb.append("\n");
        }

        System.out.print(sb);

    }
}