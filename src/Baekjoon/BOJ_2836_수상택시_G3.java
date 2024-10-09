package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_2836_수상택시_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static List<int[]> back = new ArrayList<int[]>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if(from > to){
                back.add(new int[]{from,to});
            }
        }

        back.sort((o1, o2) -> {
//            if(o1[0] != o2[0]){
//                return o1[0] - o2[0];
//            }else{
//                return o1[1] - o2[1];
//            }
            return o1[1]-o2[1];
        });

        long ans = M;
        int st = back.get(0)[1];
        int end = back.get(0)[0];

        for(int[] arr : back) {
            if(end < arr[1]){
                ans += (end - st) * 2L;
                st = arr[1];
                end = arr[0];
                continue;
            }
            end = Math.max(end, arr[0]);
            st = Math.min(st, arr[1]);
        }
        ans += (end - st) * 2L;
        System.out.println(ans);
    }
}