package Baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-24
종료 시간 : 24-02-24
실행 시간 : 1028ms
메 모 리 : 312860KB
*/

public class BOJ_15961_회전초밥_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, D, K, C;
    static int[] sushi;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
    }


    public static void main(String[] args) throws IOException {

        input();

        Map<Integer, Integer> variety = new HashMap<>();

        // 처음 K개의 초밥 가짓수 계산
        for (int i = 0; i < K; i++) {
            if(variety.containsKey(sushi[i])) variety.replace(sushi[i], variety.get(sushi[i])+1);
            else variety.put(sushi[i], 1);
        }
        int ans = variety.containsKey(C) ? variety.size() : variety.size()+1;

        // 한칸씩 오른쪽으로 이동하며 최대 초밥 개수 탐색
        int slide = 1;
        int l = 0, r = K;
        while (slide < N) {
            // 왼쪽 값 제거
            if(variety.get(sushi[l]) == 1) variety.remove(sushi[l]);
            else variety.replace(sushi[l], variety.get(sushi[l])-1);

            // 오른쪽 값 추가
            if(variety.containsKey(sushi[r])) variety.replace(sushi[r], variety.get(sushi[r])+1);
            else variety.put(sushi[r], 1);

            int tempAns = variety.containsKey(C) ? variety.size() : variety.size()+1;
            ans = Math.max(ans, tempAns);

            l++;
            r = (r+1) % N;
            slide++;
        }

        System.out.println(ans);
        bw.close();
        br.close();
    }
}
