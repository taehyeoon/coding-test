package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
시작 시간 : 24-10-14
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1082_방번호 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static int N, pocket;
    private static int[] res = new int[100];
    private static Number[] arr;
    private static Map<Integer, Integer> map = new HashMap<>();

    static class Number {
        int num, price;
        public Number(int num, int price) {
            this.num = num;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new Number[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = new Number(i, Integer.parseInt(st.nextToken()));
            map.put(i, arr[i].price);
        }

        pocket = Integer.parseInt(br.readLine());

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.price == o2.price) return o1.num - o2.num;
            return o1.price - o2.price;
        });

        int cnt = 0;

        ///
        if(arr[0].num == 0){
            if(N == 1 || arr[1].price > pocket){
                System.out.println(0);
                return;
            }

            res[cnt++] = arr[1].num;
            pocket -= arr[1].price;
        }

        while(pocket - arr[0].price >= 0){
            res[cnt++] = arr[0].num;
            pocket -= arr[0].price;
        }

        for (int i = 0; i < cnt; i++) {
            for (int j = N-1; j >= 0; j--) {
                if(i == 0 && j == 0) continue;

                int tmp = pocket + map.get(res[i]) - map.get(j);
                if(tmp >= 0){
                    pocket = tmp;
                    res[i] = j;
                    break;
                }
            }
        }

        for (int i = 0; i < cnt; i++) {
            System.out.print(res[i]);
        }


    }
}