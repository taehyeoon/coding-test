package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1969_DNA {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static char[] chars = { 'A', 'C', 'G', 'T' };
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];
        int[][] freq = new int[M][4]; // A, C, G, T

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();

            for (int j = 0; j < M; j++) {
                switch (arr[i].charAt(j)) {
                    case 'A': freq[j][0]++; break;
                    case 'C': freq[j][1]++; break;
                    case 'G': freq[j][2]++; break;
                    case 'T': freq[j][3]++; break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int diff = 0;
        for (int i = 0; i < M; i++) {
            int cnt = 0;
            int charIdx = -1;
            for (int j = 3; j >= 0; j--) {
                if(freq[i][j] >= cnt){
                    cnt = freq[i][j];
                    charIdx = j;
                }
            }

            diff += N-cnt;
            sb.append(chars[charIdx]);
        }

        System.out.println(sb);
        System.out.println(diff);

    }
}