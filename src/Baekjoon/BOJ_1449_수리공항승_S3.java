package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-10 14:35
종료 시간 : 24-03-10 14:45
실행 시간 : 80ms
메 모 리 : 11632KB
*/

public class BOJ_1449_수리공항승_S3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, L;
    static int[] hole;

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        hole = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hole[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {

        input();

        Arrays.sort(hole);

        double last = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(last >= hole[i] + 0.5) continue;

            cnt++;
            last = hole[i]+(double)L - 0.5;
        }

        System.out.println(cnt);
    }
}