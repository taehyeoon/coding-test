package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-30 16:30
종료 시간 : 24-05-30 17:10
실행 시간 : 608ms
메 모 리 : 47888KB
*/

public class BOJ_12892_생일선물_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, D;
    static int[][] data;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        data = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        Arrays.sort(data, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        long maxHappiness = 0;
        long currentHappiness = 0;
        int left = 0;

        for (int right = 0; right < N; right++) {
            currentHappiness += data[right][1];

            while (data[right][0] - data[left][0] >= D) {
                currentHappiness -= data[left][1];
                left++;
            }

            maxHappiness = Math.max(maxHappiness, currentHappiness);
        }

        System.out.println(maxHappiness);
    }
}