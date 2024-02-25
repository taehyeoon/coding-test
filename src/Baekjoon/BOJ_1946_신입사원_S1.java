package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-25
종료 시간 : 24-02-25
실행 시간 : 3256ms
메 모 리 : 312792KB
*/

public class BOJ_1946_신입사원_S1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int TC, N, ans;
        TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            ans = 1;
            N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[i] = new int[]{a, b};
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0], o2[0]);
                }
            });

            int min = arr[0][1];
            for (int i = 1; i < N; i++) {

                if(arr[i][1] < min){
                    ans++;
                    min = arr[i][1];
                }

            }
            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
