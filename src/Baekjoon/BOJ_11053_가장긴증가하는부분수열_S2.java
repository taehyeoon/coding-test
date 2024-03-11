package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-10 20:40
종료 시간 : 24-03-10 21:50
실행 시간 : 140ms
메 모 리 : 14396KB
*/

public class BOJ_11053_가장긴증가하는부분수열_S2 {

    static class Info{
        int cnt;
        int max;

        public Info(int cnt, int max) {
            this.cnt = cnt;
            this.max = max;
        }
    }
    static int N;
    static int[] data;

    static List<Info> exclude, include;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        exclude = new ArrayList<>(N);
        include = new ArrayList<>(N);
    }

    public static void main(String[] args) throws IOException {
        input();

        exclude.add(new Info(0, 0));
        include.add(new Info(1, data[0]));

        for (int i = 1; i < N; i++) {
            Info ex = exclude.get(i-1);
            Info in = include.get(i-1);
            int prevMin = Math.min(ex.max, in.max);

            // exclude
            if(ex.cnt > in.cnt){
                exclude.add(ex);
            } else if (ex.cnt < in.cnt) {
                exclude.add(in);
            }else{
                exclude.add(new Info(ex.cnt, prevMin));
            }

            // include
            int cnt = 0;
            int d = data[i];
            for (int j = 0; j < i; j++) {
                if(include.get(j).cnt > cnt && include.get(j).max < d)
                    cnt = include.get(j).cnt;
                if(exclude.get(j).cnt > cnt && exclude.get(j).max < d)
                    cnt = exclude.get(j).cnt;
            }

            include.add(new Info(cnt+1, data[i]));

        }

        int result = Math.max(exclude.get(N-1).cnt, include.get(N-1).cnt);
        System.out.println(result);
    }
}