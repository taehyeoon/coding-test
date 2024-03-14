package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-14 21:20
종료 시간 : 24-03-14 21:40
실행 시간 : 1172ms
메 모 리 : 242300KB
*/

public class BOJ_24954_물약구매_S1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, ans = Integer.MAX_VALUE;
    static int[] price, order;
    static boolean[] visited;
    static List<int[]>[] sale;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        price = new int[N+1];
        order = new int[N];
        visited = new boolean[N+1];
        sale = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            sale[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int discount = Integer.parseInt(st.nextToken());
                sale[i].add(new int[]{p, discount});
            }
        }
    }

    private static void calc(){

        int[] copiedPrice = Arrays.copyOf(price, price.length);
        // order 순서대로 계산
        int sum = 0;
        for (int i = 0; i < N; i++) {

            int buyIdx = order[i];
            // 구매
            sum += copiedPrice[buyIdx];

            // 할인
            for (int j = 0; j < sale[buyIdx].size(); j++) {
                int thing = sale[buyIdx].get(j)[0];
                int discount = sale[buyIdx].get(j)[1];

                copiedPrice[thing] = Math.max(1, copiedPrice[thing] - discount);
            }
        }

        ans = Math.min(ans, sum);
    }
    private static void per(int cnt){

        if(cnt == N){
            calc();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(visited[i]) continue;

            order[cnt] = i;
            visited[i] = true;
            per(cnt+1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {

        input();

        per(0);

        System.out.println(ans);
    }
}